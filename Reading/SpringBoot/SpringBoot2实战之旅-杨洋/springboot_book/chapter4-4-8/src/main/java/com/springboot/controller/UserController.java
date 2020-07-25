package com.springboot.controller;

import com.springboot.dao.UserMapper;
import com.springboot.entity.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //http://localhost:8080/getUserListPage?pageNum=1&pageSize=2
    @GetMapping("getUserListPage")
    public List<User> getUserListPage(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.getUserListPage();
    }
}
