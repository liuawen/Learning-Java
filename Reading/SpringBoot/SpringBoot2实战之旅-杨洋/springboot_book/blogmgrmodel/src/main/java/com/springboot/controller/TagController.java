package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {
    @GetMapping("/tag")
    public String tag(){
        return "tag/index";
    }
}
