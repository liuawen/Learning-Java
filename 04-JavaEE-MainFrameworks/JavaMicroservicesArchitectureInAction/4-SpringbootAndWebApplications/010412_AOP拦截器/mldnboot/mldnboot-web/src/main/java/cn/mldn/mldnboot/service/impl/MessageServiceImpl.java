package cn.mldn.mldnboot.service.impl;

import org.springframework.stereotype.Service;

import cn.mldn.mldnboot.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
	@Override
	public String echo(String msg) {
		return "【ECHO】" + msg;
	}

}
