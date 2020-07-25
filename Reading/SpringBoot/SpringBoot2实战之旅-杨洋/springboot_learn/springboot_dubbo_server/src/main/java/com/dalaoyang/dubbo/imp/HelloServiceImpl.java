package com.dalaoyang.dubbo.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.dalaoyang.dubbo.HelloService;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.dubbo.imp
 * @email yangyang@dalaoyang.cn
 * @date 2018/6/14
 */
@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String SayHello(String name) {
        return "Hello , "+name;
    }
}
