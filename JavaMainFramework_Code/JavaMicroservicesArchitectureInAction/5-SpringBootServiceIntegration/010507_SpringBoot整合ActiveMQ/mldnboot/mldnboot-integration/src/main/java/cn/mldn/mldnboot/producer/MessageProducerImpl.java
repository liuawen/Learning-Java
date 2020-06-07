package cn.mldn.mldnboot.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerImpl implements IMessageProducer {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;				// 消息发送模版
	@Autowired
	private Queue queue;											// 注入队列
	@Override
	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);	// 消息发送

	}

}
