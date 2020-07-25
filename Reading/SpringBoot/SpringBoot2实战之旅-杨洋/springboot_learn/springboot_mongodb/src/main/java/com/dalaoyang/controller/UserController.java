package com.dalaoyang.controller;

import com.dalaoyang.entity.UserInfo;
import com.dalaoyang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/5
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //http://localhost:8888/save
    @GetMapping("save")
    public String save(){
        UserInfo userInfo = new UserInfo(System.currentTimeMillis(),"用户"+System.currentTimeMillis(),"123");
        userRepository.save(userInfo);
        return "success";
    }

    //http://localhost:8888/getUserList
    @GetMapping("getUserList")
    public List<UserInfo> getUserList(){
        List<UserInfo> userInfoList = userRepository.findAll();
        return userInfoList;
    }

    //http://localhost:8888/delete?id=1525503798382
    @GetMapping("delete")
    public String delete(Long id){
        userRepository.delete(id);
        return "success";
    }

    //http://localhost:8888/update?id=1525503912550&username=111&password=222
    @GetMapping("update")
    public String update(Long id,String username,String password){
        UserInfo userInfo = new UserInfo(id,username,password);
        userRepository.save(userInfo);
        return "success";
    }
}
