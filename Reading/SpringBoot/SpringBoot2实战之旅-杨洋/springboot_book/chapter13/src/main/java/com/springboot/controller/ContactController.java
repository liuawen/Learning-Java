package com.springboot.controller;

import com.springboot.entity.Message;
import com.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @Autowired
    private MessageService messageService;

    @PostMapping("/contact/sendMail")
    @ResponseBody
    @Transactional(rollbackFor = Throwable.class)
    public String sendMail(@RequestBody Message message) {
        message.setMessageInputDate(new Date());
        messageService.saveMessage(message);
        return "success";
    }
}
