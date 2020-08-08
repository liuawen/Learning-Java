package cn.mldn.mldnboot.producer.impl;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import cn.mldn.mldnboot.producer.IMessageProducer;
@Service 
public class MessageProducerImpl implements IMessageProducer {
	@Resource
	private KafkaTemplate<String, String> kafkaTemplate;	// Kafka消息模版
	@Override
	public void send(String msg) {
		this.kafkaTemplate.sendDefault("mldn-key", msg);	// 发送消息
	}
}

