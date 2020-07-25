package com.dalaoyang.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author yangyang
 * @date 2019/2/4
 */
@RestController
public class TestController {

    @GetMapping("/test/{string}")
    public String test(@PathVariable String string) {
        return "Hello Nacos :" + string;
    }
}
