package com.springboot.timer;

import com.springboot.constants.Constants;
import com.springboot.entity.WebsiteAccess;
import com.springboot.entity.WebsiteConfig;
import com.springboot.service.MessageService;
import com.springboot.service.WebsiteAccessService;
import com.springboot.service.WebsiteConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class WebSiteTimer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WebsiteConfigService websiteConfigService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private WebsiteAccessService websiteAccessService;
    @Autowired
    private MessageService messageService;
    @Scheduled(cron = "0 0 0 1/1 * ?")
    private void sendDailyData() {
        String subject = "博客每日数据";
        String text = this.initData();
        WebsiteConfig websiteConfig = websiteConfigService.findWebsiteConfig();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(websiteConfig.getEmailUsername());
        simpleMailMessage.setTo(websiteConfig.getEmailUsername());
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        try {
            javaMailSender.send(simpleMailMessage);
            logger.info("发送博客每日数据成功！");
        } catch (Exception e) {
            logger.error("发送博客每日数据异常！", e);
        }
    }

    private String initData(){
        StringBuffer stringBuffer = new StringBuffer();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        WebsiteAccess websiteAccess = websiteAccessService.getByAccessDateIs(new Date());
        stringBuffer.append("日期是：");
        stringBuffer.append(sdf.format(websiteAccess.getAccessDate()));
        stringBuffer.append("访问量为：");
        stringBuffer.append(websiteAccess.getAccessCount());
        stringBuffer.append("未读消息有：");
        int count = messageService.countByIsRead(Constants.YES);
        stringBuffer.append(count);
        stringBuffer.append("条");
        return stringBuffer.toString();
    }
}
