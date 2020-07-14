package com.imooc.springboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/06/02
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello",headers = "version=2")
    public String hello(@RequestParam(required = false) String name) {
        if (name == null || "".equals(name)) {
            name = "Spring Boot";
        }
        return "Hello "+name;
    }
}
