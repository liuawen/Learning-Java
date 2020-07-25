package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //http://localhost:8080/getUser?username=xiaoli2
    @GetMapping("/getUser")
    public String getUser(String username){
        User user =userMapper.findUserByUsername(username);
        return user!=null ? username+"的密码是："+user.getUser_password():"不存在用户名为"+username+"的用户";
    }

    //http://localhost:8080/updateUser?username=xiaoli2&password=123
    @GetMapping("/updateUser")
    public String updateUser(String password,String username){
        User user = new User(username,password);
        userMapper.updateUserByUsername(user);
        return "success!";
    }


    //http://localhost:8080/addUser?username=xiaoli2&password=123
    @GetMapping("/addUser")
    public String addUser(String username,String password){
        User user = new User(username,password);
        userMapper.saveUser(user);
        return "success!";
    }

    //http://localhost:8080/deleteUser?username=xiaoli2
    @GetMapping("/deleteUser")
    public String deleteUser(String username){
        userMapper.deleteUserByUsername(username);
        return "success!";
    }

    //http://localhost:8080/getUserList
    @GetMapping("/getUserList")
    public List getUserList(){
        return userMapper.getUserList();
    }

    //http://localhost:8080/findAll
    @GetMapping("/findAll")
    public List findAll(){
        return userMapper.findAll();
    }

    //http://localhost:8080/findUserById?id=1
    @GetMapping("/findUserById")
    public List findUserById(int id){
        return userMapper.findUserById(id);
    }
}
