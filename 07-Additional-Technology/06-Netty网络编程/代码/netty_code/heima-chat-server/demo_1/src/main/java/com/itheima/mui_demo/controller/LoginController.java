package com.itheima.mui_demo.controller;

import com.itheima.mui_demo.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public Map login(@RequestBody User user) {
        System.out.println(user);

        Map map = new HashMap<String, Object>();

        if("tom".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            map.put("success", true);
            map.put("message", "登录成功");
        }
        else {
            map.put("success", false);
            map.put("message", "登录失败，请检查用户名和密码是否输入正确");
        }

        return map;
    }
}
