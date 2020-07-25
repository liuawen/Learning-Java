package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
    @GetMapping("/message")
    public String message(){
        return "message/index";
    }

    @GetMapping("/messageInfo")
    public String messageInfo(){
        return "message/edit";
    }
}
