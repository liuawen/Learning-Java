package com.springboot.receiver;

import com.springboot.config.DirectConfig;
import com.springboot.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {
    private static final Logger log = LoggerFactory.getLogger(DirectReceiver.class);

    // queues是指要监听的队列的名字
    @RabbitListener(queues = DirectConfig.DIRECT_QUEUE)
    public void receiverDirectQueue(Goods goods) {
        log.info("简单消息接受成功，参数是：" + goods.toString());
    }
}
