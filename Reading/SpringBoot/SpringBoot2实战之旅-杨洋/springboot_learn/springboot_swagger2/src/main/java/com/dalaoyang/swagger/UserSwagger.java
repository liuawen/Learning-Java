package com.dalaoyang.swagger;

import com.dalaoyang.model.User;
import com.dalaoyang.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.swagger
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/9
 */
@RestController
@RequestMapping(value="/users")
@Api(value="用户操作接口",tags={"用户操作接口"})
public class UserSwagger {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value="获取用户详细信息", notes="根据用户的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query", dataType = "Integer")
    @GetMapping(value="/findById")
    public User findById(@RequestParam(value = "id")int id){
        User user = userRepository.findById(id);
        return user;
    }

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping(value="/getUserList")
    public List getUserList(){
        return userRepository.findAll();
    }


    @ApiOperation(value="保存用户", notes="保存用户")
    @PostMapping(value="/saveUser")
    public String saveUser(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) User user){
        userRepository.save(user);
        return "success!";
    }

    @ApiOperation(value="修改用户", notes="修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键id",required=true,paramType="query",dataType="Integer"),
            @ApiImplicitParam(name="username",value="用户名称",required=true,paramType="query",dataType = "String"),
            @ApiImplicitParam(name="password",value="用户密码",required=true,paramType="query",dataType = "String")
    })
    @PutMapping(value="/updateUser")
    public String updateUser(@RequestParam(value = "id")int id,@RequestParam(value = "username")String username,
                             @RequestParam(value = "password")String password){
        User user = new User(id, username, password);
        userRepository.save(user);
        return "success!";
    }


    @ApiOperation(value="删除用户", notes="根据用户的id来删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query", dataType = "Integer")
    @DeleteMapping(value="/deleteUserById")
    public String deleteUserById(@RequestParam(value = "id")int id){
        User user = userRepository.findById(id);
        userRepository.delete(user);
        return "success!";
    }

}
