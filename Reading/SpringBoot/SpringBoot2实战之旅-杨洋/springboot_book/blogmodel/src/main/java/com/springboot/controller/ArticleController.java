package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("/articleDetailDemo")
    public String articleDetailDemo(){
        return "articleDetailDemo";
    }
}
