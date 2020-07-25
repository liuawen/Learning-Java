package com.springboot.receiver;

import com.springboot.config.TopicConfig;
import com.springboot.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
    private static final Logger log = LoggerFactory.getLogger(TopicReceiver.class);

    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE1)
    public void receiveTopic1(Goods goods) {
        log.info("receiveTopic1收到消息：" + goods.toString());
    }
    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE2)
    public void receiveTopic2(Goods goods) {
        log.info("receiveTopic2收到消息：" + goods.toString());
    }
}
