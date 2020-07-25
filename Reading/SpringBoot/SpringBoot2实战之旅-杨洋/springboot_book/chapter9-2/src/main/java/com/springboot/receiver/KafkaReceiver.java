package com.springboot.receiver;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class KafkaReceiver {
    private static final Logger log = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(topics = "goods")
    public void send(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object messge = kafkaMessage.get();
            log.info("【KafkaListener监听到消息】" + messge);
        }
    }
}
