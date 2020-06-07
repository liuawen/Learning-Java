package cn.mldn.mldnboot.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
	@JmsListener(destination="mldn.msg.queue")	// 定义消息监听队列
	public void receiveMessage(String text) {	// 进行消息接收处理
		System.err.println("【*** 接收消息 ***】" + text);
	}
}
