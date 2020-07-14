package com.imooc.springboot.mybatis.controller;

import com.imooc.springboot.mybatis.mapper.UserMapper;
import com.imooc.springboot.mybatis.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/07/07
 */
@Api
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @ApiOperation(value = "获取用户列表")
    @GetMapping("")
    public List<User> list() {
        return userMapper.selectByExample(null);
    }

    @ApiOperation(value = "创建用户")
    @PostMapping("")
    public int create(@RequestBody User user) {
        return userMapper.insert(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("")
    public int update(@RequestBody User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

}
