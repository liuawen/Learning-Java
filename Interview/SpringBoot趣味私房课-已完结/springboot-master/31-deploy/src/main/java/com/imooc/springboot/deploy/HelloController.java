package com.imooc.springboot.deploy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2020/03/29
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(@RequestParam(required = false) String name) {
        if (name == null || "".equals(name)) {
            name = "Spring Boo t!";
        }
        return "Hello "+name;
    }
}
