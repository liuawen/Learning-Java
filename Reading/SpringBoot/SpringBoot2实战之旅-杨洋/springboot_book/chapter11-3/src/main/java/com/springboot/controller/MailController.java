package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${mail.fromMail.sender}")
    private String sender;

    @Value("${mail.fromMail.receiver}")
    private String receiver;

    @GetMapping("simpleMail")
    public void simpleMail(){
        String subject = "文本邮件";
        String text = "文本邮件正文内容";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        try {
            javaMailSender.send(simpleMailMessage);
            logger.info("发送文本邮件成功！");
        } catch (Exception e) {
            logger.error("发送文本邮件时发生异常！", e);
        }
    }

    @GetMapping("/htmlMail")
    public void htmlMail() {
        String subject = "网页邮件";
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
            logger.info("发送网页邮件成功！");
        } catch (Exception e) {
            logger.error("发送网页邮件时发生异常！", e);
        }
    }

    @RequestMapping("/filesMail")
    public void filesMail() {
        String subject = "附件邮件";
        String text = "附件邮件正文内容";
        String filePath="/Users/dalaoyang/Desktop/settings.xml";
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(text, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            javaMailSender.send(message);
            logger.info("发送附近邮件成功！");
        } catch (Exception e) {
            logger.error("发送附件邮件时发生异常！", e);
        }
    }

    @RequestMapping("/inlineResourceMail")
    public void inlineResourceMail() {
        String Id = "test001";
        String subject = "嵌入静态资源邮件";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><body>这是有图片的邮件：");
        stringBuilder.append("<img src='cid:" + Id + "' >");
        stringBuilder.append("</body></html>");
        String content = stringBuilder.toString();
        String imgPath = "/Users/dalaoyang/Desktop/mail.jpg";
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource res = new FileSystemResource(new File(imgPath));
            helper.addInline(Id, res);
            javaMailSender.send(message);
            logger.info("嵌入静态资源邮件成功！");
        } catch (Exception e) {
            logger.error("发送嵌入静态资源邮件时发生异常！", e);
        }
    }
}
