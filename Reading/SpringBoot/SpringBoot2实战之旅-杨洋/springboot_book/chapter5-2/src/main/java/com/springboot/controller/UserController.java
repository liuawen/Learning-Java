package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "saveUser")
    public String saveUser(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        redisService.set(id.toString(), user);
        return "success";
    }

    @GetMapping(value = "getUserById")
    public Object getUserById(Long id) {
        return redisService.get(id.toString());
    }

    @GetMapping("/saveUser2")
    public User saveUser2(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        userRepository.save(user);
        return user;
    }

    @GetMapping(value = "getUser")
    public Object getUser(Long id) {
        Object object = redisService.get(id.toString());
        if (object == null) {
            object = (userRepository.findById(id)).get();
            if (object != null) {
                redisService.set(id.toString(), object, 100L, TimeUnit.SECONDS);
            }
        }
        return object;
    }
}
