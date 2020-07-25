package com.dalaoyang.receiver;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.receiver
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/25
 */
@Component
@RabbitListener(queues = "message")
public class Receiver {
    Logger logger = Logger.getLogger(Receiver.class);

    @RabbitHandler
    public void process(String Str) {
        logger.info("接收消息："+Str);
        logger.info("接收消息时间："+new Date());
    }
}
