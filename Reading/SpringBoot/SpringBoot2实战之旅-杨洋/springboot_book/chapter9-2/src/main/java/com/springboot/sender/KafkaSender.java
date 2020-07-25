package com.springboot.sender;

import com.springboot.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    private static final Logger log = LoggerFactory.getLogger(KafkaSender.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        Goods goods = new Goods(System.currentTimeMillis(),"测试商品","这是一个测试的商品",98.6);
        log.info("KafkaSender已发送消息");
        kafkaTemplate.send("goods", goods.toString());
    }
}
