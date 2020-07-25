package com.springboot.controller;

import com.springboot.listener.MyHttpSessionListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class TestController {

    @GetMapping("/addSession")
    public String addSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name", "dalaoyang");
        return "当前在线人数" + MyHttpSessionListener.online;
    }

    @GetMapping("/removeSession")
    public String removeSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "当前在线人数" + MyHttpSessionListener.online;
    }

    @GetMapping("/online")
    public String online() {
        return "当前在线人数：" + MyHttpSessionListener.online + "人";
    }
}
