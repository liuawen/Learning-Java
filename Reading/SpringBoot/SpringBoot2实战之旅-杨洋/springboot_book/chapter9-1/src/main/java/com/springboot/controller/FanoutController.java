package com.springboot.controller;

import com.springboot.sender.FanoutSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FanoutController {
    @Autowired
    private FanoutSender fanoutSender;

    @GetMapping("fanoutTest")
    public void fanoutTest(){
        fanoutSender.sendFanoutQueue();
    }
}
