package com.dalaoyang.controller;

import com.dalaoyang.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/7
 */
@RestController
public class UserController {

    @GetMapping("/testUser")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("dalaoyang");
        user.setPassword("123");
        System.out.println(user.toString());
        return user;
    }
}
