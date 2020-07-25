package com.dalaoyang.controller;


import com.dalaoyang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping({"/", ""})
    public String login(String username, String password) {
        return loginService.login(username, password);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        return loginService.logout(request);
    }
}
