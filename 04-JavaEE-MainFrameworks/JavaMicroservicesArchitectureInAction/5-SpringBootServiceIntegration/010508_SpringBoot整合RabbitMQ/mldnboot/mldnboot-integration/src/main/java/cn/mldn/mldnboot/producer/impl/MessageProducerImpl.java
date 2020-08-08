package cn.mldn.mldnboot.producer.impl;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import cn.mldn.mldnboot.config.ProducerConfig;
import cn.mldn.mldnboot.producer.IMessageProducer;
 
@Service
public class MessageProducerImpl implements IMessageProducer {
	@Resource
	private RabbitTemplate rabbitTemplate; 
	@Override
	public void send(String msg) {
		this.rabbitTemplate.convertAndSend(ProducerConfig.EXCHANGE,
				ProducerConfig.ROUTINGKEY, msg);
	}
}
