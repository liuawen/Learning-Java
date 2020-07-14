package com.imooc.springboot.jpa.controller;

import com.imooc.springboot.jpa.model.User;
import com.imooc.springboot.jpa.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
    private UserRepository userRepository;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userRepository.findById(id).get();
    }
    @ApiOperation(value = "获取用户列表")
    @GetMapping("")
    public Page<User> list(String property, String direction, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(direction),property);

        return userRepository.findAll(pageable);
    }

    @ApiOperation(value = "获取用户列表）支持模糊查询）")
    @GetMapping("/page/{name}")
    public Page<User> queryByName(@PathVariable String name, String direction, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);

        return userRepository.findByNameContaining(name, pageable);
    }

    @ApiOperation(value = "创建用户")
    @PostMapping("")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("")
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @ApiOperation(value = "根据年龄查询用户")
    @GetMapping("/age/{age}")
    public List<User> getByAge(@PathVariable Integer age) {
        return userRepository.findByAge(age);
    }
}
