package com.dalaoyang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private RedisService redisService;

    public String login(String username, String password) {
        if (Objects.equals("dalaoyang", username) &&
                Objects.equals("123", password)) {
            String token = UUID.randomUUID().toString();
            redisService.set(token, username);
            return "用户：" + username + "登录成功，token是：" + token;
        } else {
            return "用户名或密码错误，登录失败！";
        }
    }

    public String logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        Boolean delete = redisService.delete(token);
        if (!delete) {
            return "注销失败，请检查是否登录！";
        }
        return "注销成功！";
    }
}
