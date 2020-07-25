package com.springboot.sender;

import com.springboot.config.DirectConfig;
import com.springboot.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {
    private static final Logger log = LoggerFactory.getLogger(DirectSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue() {
        Goods goods = new Goods(System.currentTimeMillis(),"测试商品","这是一个测试的商品",98.6);
        log.info("简单消息已经发送");
        // 第一个参数是指要发送到哪个队列里面， 第二个参数是指要发送的内容
        this.amqpTemplate.convertAndSend(DirectConfig.DIRECT_QUEUE, goods);
    }
}
