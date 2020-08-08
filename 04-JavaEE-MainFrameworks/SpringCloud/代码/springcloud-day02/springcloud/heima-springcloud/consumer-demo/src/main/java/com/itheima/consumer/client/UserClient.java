package com.itheima.consumer.client;

import com.itheima.consumer.client.fallback.UserClientFallback;
import com.itheima.consumer.config.FeignConfig;
import com.itheima.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//声明当前类是一个Feign客户端，指定服务名为user-service
@FeignClient(value = "user-service", fallback = UserClientFallback.class,
configuration = FeignConfig.class)
public interface UserClient {

    //http://user-service/user/123
    @GetMapping("/user/{id}")
    User queryById(@PathVariable Long id);
}
