package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnuseModelController {
    @GetMapping("/forms")
    public String forms(){
        return "unuse/forms";
    }

    @GetMapping("/charts")
    public String charts(){
        return "unuse/charts";
    }

    @GetMapping("/tables")
    public String tables(){
        return "unuse/tables";
    }
}
