package com.springboot.sender;

import com.springboot.config.FanoutConfig;
import com.springboot.config.TopicConfig;
import com.springboot.entity.Goods;
import com.springboot.receiver.FanoutReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    private static final Logger log = LoggerFactory.getLogger(FanoutSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendFanoutQueue() {
        Goods goods = new Goods(System.currentTimeMillis(),"测试商品","这是一个测试的商品",98.6);
        log.info("sendFanoutQueue已发送消息");
        this.amqpTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE, "", goods );
    }
}
