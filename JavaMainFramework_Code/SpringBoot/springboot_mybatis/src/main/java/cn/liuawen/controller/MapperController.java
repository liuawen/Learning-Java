package cn.liuawen.controller;

import cn.liuawen.domain.User;
import cn.liuawen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-15
 */
@Controller
public class MapperController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("queryUser")
    @ResponseBody
    public List<User> queryUser(){
        List<User> userList = userMapper.queryUserList();
        return userList;
    }
}
