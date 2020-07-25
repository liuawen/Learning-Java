package com.dalaoyang.interfaces;

import com.dalaoyang.back.FeignFallbackService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dalaoyang
 * @Description
 * @project springcloud_learn
 * @package com.dalaoyang.interfaces
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/20
 */
@FeignClient(value="service",fallback = FeignFallbackService.class)
//这里是要远程调用的服务的名称，即你要调用服务的spring.application.name
//fallback是远程调用失败回调的方法
public interface FeignInterface {
    @GetMapping("/")
    String IndexInfo();
}
