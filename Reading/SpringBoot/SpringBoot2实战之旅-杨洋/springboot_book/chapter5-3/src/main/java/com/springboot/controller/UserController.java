package com.springboot.controller;

import com.springboot.config.MemcachedConfig;
import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private MemcachedConfig memcachedConfig;

    @GetMapping(value = "saveUser")
    public Boolean saveUser(Long id, String userName, String userPassword){
        User user = new User(id, userName, userPassword);
        return memcachedConfig.set(id.toString(), 1000,user.toString());
    }

    @GetMapping(value = "getUserById")
    public Object getUserById(Long id) {
        return memcachedConfig.get(id.toString());
    }

    @GetMapping(value = "deleteCacheById")
    public Boolean deleteCacheById(Long id) {
        return memcachedConfig.delete(id.toString());
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/saveUser2")
    public User saveUser2(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        userRepository.save(user);
        return user;
    }

    @GetMapping(value = "getUserById2")
    public Object getUserById2(Long id) {
        Object object = memcachedConfig.get(id.toString());
        if (object == null) {
            object = (userRepository.findById(id)).get();
            if (object != null) {
                memcachedConfig.set(id.toString(), 1000, object.toString());
            }
        }
        return object;
    }
}
