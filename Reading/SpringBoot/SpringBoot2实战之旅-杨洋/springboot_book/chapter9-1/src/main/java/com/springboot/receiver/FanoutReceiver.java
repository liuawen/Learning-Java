package com.springboot.receiver;

import com.springboot.config.FanoutConfig;
import com.springboot.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    private static final Logger log = LoggerFactory.getLogger(FanoutReceiver.class);

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE1)
    public void receiveFanout1(Goods goods) {
        log.info("receiveFanoutQueue1监听到消息：" + goods.toString());
    }
    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE2)
    public void receiveFanout2(Goods goods) {
        log.info("receiveFanoutQueue2监听到消息：" + goods.toString());
    }
}
