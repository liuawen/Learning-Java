package com.dalaoyang.controller;

import com.dalaoyang.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/25
 */
@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @GetMapping("hello")
    public String helloTest(){
        sender.send();
        return "success";
    }

}
