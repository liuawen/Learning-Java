package cn.mldn.mldnboot.config;		// 放在主类所在子包

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.mldn.mldnboot.util.MessageUtil;

@Configuration							// 本类为配置Bean
public class DefaultConfig {
	@Bean(name="messageUtil")			// 定义Bean
	public MessageUtil getMessageUtil() {
		return new MessageUtil() ;		// 配置Bean对象
	}
}
