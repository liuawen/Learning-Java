package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
    @RequestMapping({"/","/index"})
    public String index(){
        return"index";
    }

    @RequestMapping("/select")
    public String select(){
        return "select";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login_error")
    public String login_error(Model model){
        model.addAttribute("login_error", "用户名或密码错误");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        model.addAttribute("login_error", "注销成功");
        return "login";
    }

    @RequestMapping("/401")
    public String error(){
        return "401";
    }
}
