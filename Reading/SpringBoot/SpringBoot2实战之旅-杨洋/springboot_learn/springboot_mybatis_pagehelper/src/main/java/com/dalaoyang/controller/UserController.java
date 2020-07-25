package com.dalaoyang.controller;

import com.dalaoyang.dao.UserMapper;
import com.dalaoyang.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email 397600342@qq.com
 * @date 2018/6/22
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    //http://localhost:8888/getUserList?pageNum=1&pageSize=2
    @RequestMapping("/getUserList")
    public Page<User> getUserList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<User>  userList= userMapper.getUserList();
        return userList;
    }
}
