package com.dalaoyang.controller;

import com.dalaoyang.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/8
 */
@RestController
public class UserController {

    //http://localhost:8080/json
    @GetMapping(value = "/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public User index(){
        User user = new User("dalaoyang", "26", "北京");
        return user;
    }


    //http://localhost:8080/xml
    @GetMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public User XML(){
        User user = new User("dalaoyang", "26", "北京");
        return user;
    }
}
