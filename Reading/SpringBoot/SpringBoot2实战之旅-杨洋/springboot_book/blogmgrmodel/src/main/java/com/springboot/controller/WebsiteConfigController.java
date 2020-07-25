package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteConfigController {

    @GetMapping("/system")
    public String system(){
        return "system/edit";
    }


}
