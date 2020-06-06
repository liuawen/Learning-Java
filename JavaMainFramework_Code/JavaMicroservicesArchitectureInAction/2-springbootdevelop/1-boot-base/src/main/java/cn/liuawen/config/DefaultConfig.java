package cn.liuawen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.liuawen.util.MessageUtil;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 * 配置优选顺序
 * yml > bean > xml 配置
 */
@Configuration //本类为配置Bean
public class DefaultConfig {
    @Bean(name = "messageUtil")//定义Bean
    public MessageUtil getMessageUtil(){
        return new MessageUtil();
    }
}
