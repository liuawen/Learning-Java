package com.springboot.controller;

import com.springboot.entity.User;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.terran4j.commons.api2doc.annotations.ApiError;
import com.terran4j.commons.api2doc.annotations.ApiErrors;
import org.springframework.web.bind.annotation.*;

@Api2Doc(id = "users", name = "用户接口", order = 1)
@ApiComment(seeClass = User.class)
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Api2Doc(order = 1)
    @ApiComment("新增用户")
    @ApiErrors({
            @ApiError(value = "is-exists", comment = "此用户已经存在！"),
            @ApiError(value = "error", comment = "错误！")
    })
    @PostMapping(name = "新增用户",value="/addUser")
    public User addUser(
            @ApiComment(value = "用户名称",seeField = "id") @RequestParam(required = true) Long id,
            @ApiComment(value = "用户名称",seeField = "userName") @RequestParam(required = true) String userName,
            @ApiComment(value = "用户密码",seeField = "userPassword") @RequestParam(required = true) String userPassword) {
        User user = new User(id,userName,userPassword);
        return user;
    }

    @Api2Doc(order = 2)
    @ApiComment("根据用户ID查询用户")
    @ApiError(value = "not-found", comment = "此用户不存在！")
    @GetMapping(name = "查询用户", value = "/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return new User(id,"dalaoyang","123");
    }
}
