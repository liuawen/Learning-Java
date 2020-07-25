package com.springboot.sender;

import com.springboot.config.TopicConfig;
import com.springboot.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TopicSender {
    private static final Logger log = LoggerFactory.getLogger(TopicSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendTopicQueue() {
        Goods goods1 = new Goods(System.currentTimeMillis(),"测试商品1","这是第一个测试的商品",98.6);
        Goods goods2 = new Goods(System.currentTimeMillis(),"测试商品2","这是第二个测试的商品",100.0);
        log.info("TopicSender已发送消息");
        // 第一个参数：TopicExchange名字
        // 第二个参数：Route-Key
        // 第三个参数：要发送的内容
        this.amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, "topic.messge", goods1 );
        this.amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE, "topic.messge2", goods2);
    }
}
