package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

    @GetMapping("/link")
    public String link(){
        return "link/index";
    }

    @GetMapping("/editLink")
    public String editLink(){
        return "link/edit";
    }
}
