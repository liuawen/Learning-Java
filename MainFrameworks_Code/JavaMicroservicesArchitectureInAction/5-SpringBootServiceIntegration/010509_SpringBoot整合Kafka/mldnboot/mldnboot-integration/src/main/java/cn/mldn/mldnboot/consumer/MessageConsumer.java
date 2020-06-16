package cn.mldn.mldnboot.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
	@KafkaListener(topics = {"mldn-microboot"})
	public void receiveMessage(ConsumerRecord<String, String> record) { 	// 进行消息接收处理
		System.err.println("【*** 接收消息 ***】key = " + record.key() + "、value = "
				+ record.value());
	}
}
