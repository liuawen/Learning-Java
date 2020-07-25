package com.springboot.controller;

import com.springboot.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/users")
@Api(value="用户操作接口",tags={"用户操作接口"})
public class UserController {

    @ApiOperation(value="获取用户详细信息", notes="根据用户的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query", dataType = "long")
    @GetMapping(value="/findById")
    public User findById(@RequestParam(value = "id")long id){
        return new User(id,"dalaoyang","123");
    }


    @ApiOperation(value="保存用户", notes="保存用户")
    @PostMapping(value="/saveUser")
    public String saveUser(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) User user){
        return user.toString();
    }

    @ApiOperation(value="修改用户", notes="修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键id",required=true,paramType="query",dataType="long"),
            @ApiImplicitParam(name="username",value="用户名称",required=true,paramType="query",dataType = "String"),
            @ApiImplicitParam(name="password",value="用户密码",required=true,paramType="query",dataType = "String")
    })
    @GetMapping(value="/updateUser")
    public String updateUser(@RequestParam(value = "id")long id,@RequestParam(value = "username")String username,
                             @RequestParam(value = "password")String password){
        User user = new User(id, username, password);
        return user.toString();
    }


    @ApiOperation(value="删除用户", notes="根据用户的id来删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！"),
            @ApiResponse(code = 401,message = "未授权！"),
            @ApiResponse(code = 404,message = "页面未找到！"),
            @ApiResponse(code = 403,message = "出错了！")
    })
    @DeleteMapping(value="/deleteUserById")
    public String deleteUserById(@RequestParam(value = "id")int id){
        return "success!";
    }
}
