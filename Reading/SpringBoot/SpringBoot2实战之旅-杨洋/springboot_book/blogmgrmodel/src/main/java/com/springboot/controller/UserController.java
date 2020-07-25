package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String user(){
        return "user/index";
    }

    @GetMapping("/editUser")
    public String editUser(){
        return "user/edit";
    }
}
