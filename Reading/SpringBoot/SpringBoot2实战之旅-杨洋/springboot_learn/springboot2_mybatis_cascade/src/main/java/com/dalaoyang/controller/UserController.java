package com.dalaoyang.controller;

import com.dalaoyang.dao.UserMapper;
import com.dalaoyang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    //http://localhost:8888/getUser?username=dalaoyang
    @RequestMapping("/getUser")
    public Object getUser(String username){
        User user =userMapper.findUserByUsername(username);
        return user!=null ? user:"不存在用户名为"+username+"的用户";
    }


}
