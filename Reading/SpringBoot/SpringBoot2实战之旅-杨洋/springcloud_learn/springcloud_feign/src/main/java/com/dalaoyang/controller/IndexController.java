package com.dalaoyang.controller;

import com.dalaoyang.interfaces.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springcloud_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/20
 */
@RestController
public class IndexController {

    @Autowired
    FeignInterface feignInterface;

    @GetMapping("/")
    public String Index(){
        return feignInterface.IndexInfo();
    }
}
