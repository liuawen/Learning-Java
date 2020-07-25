package com.springboot.controller;

import com.springboot.sender.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("testKafka")
    public void testKafka(){
        kafkaSender.send();
    }
}
