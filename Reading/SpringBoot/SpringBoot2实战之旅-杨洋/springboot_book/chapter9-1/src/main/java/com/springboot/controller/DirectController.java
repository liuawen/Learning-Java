package com.springboot.controller;

import com.springboot.sender.DirectSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectController {
    @Autowired
    private DirectSender directSender;

    @GetMapping("directTest")
    public void directTest() {
        directSender.sendDirectQueue();
    }
}
