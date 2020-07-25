package com.dalaoyang.sender;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.send
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/25
 */
@Component
public class Sender {
    Logger logger = Logger.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
        String context = "简单消息发送";
        logger.info("简单消息发送时间："+new Date());
        amqpTemplate.convertAndSend("message", context);
        return "发送成功";
    }
}
