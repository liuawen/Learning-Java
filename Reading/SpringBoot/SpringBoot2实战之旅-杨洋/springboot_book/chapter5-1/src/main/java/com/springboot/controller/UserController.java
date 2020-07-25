package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/saveUser")
    @CachePut(value = "user", key = "#id")
    public User saveUser(Long id, String userName, String userPassword){
        User user = new User(id,userName, userPassword);
        userRepository.save(user);
        return user;
    }

    @GetMapping("/queryUser")
    @Cacheable(value = "user", key = "#id")
    public Optional<User> queryUser(Long id){
        return userRepository.findById(id);
    }

    @GetMapping("/deleteUser")
    @CacheEvict(value = "user", key = "#id")
    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "success";
    }

    @GetMapping("/deleteCache")
    @CacheEvict(value = "user", allEntries = true)
    public void deleteCache() {
    }
}