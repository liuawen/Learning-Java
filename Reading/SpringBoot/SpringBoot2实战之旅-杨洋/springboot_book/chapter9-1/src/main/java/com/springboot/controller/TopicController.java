package com.springboot.controller;

import com.springboot.sender.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @Autowired
    private TopicSender topicSender;

    @GetMapping("topicTest")
    public void topicTest() {
        topicSender.sendTopicQueue();
    }
}
