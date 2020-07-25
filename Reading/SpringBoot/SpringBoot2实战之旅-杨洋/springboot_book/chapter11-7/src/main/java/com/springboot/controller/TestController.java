package com.springboot.controller;

import com.springboot.annotation.DoneTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test1")
    @DoneTime(param = "TestController")
    public String test1(){
        System.out.println("方法1执行");
        return "hello springboot2";
    }

    @GetMapping("/test2")
    public String test2(){
        System.out.println("方法2执行");
        return "hello springboot2";
    }
}
