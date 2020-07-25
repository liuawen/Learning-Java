package com.springboot.controller;

import com.springboot.sender.RocketMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketMQController {
    @Autowired
    private RocketMQSender rocketMQSender;

    @GetMapping("testRocketmq")
    public void testRocketmq(){
        rocketMQSender.defaultMQProducer();
    }
}
