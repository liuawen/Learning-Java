package com.dalaoyang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/7/30
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String Hello(){
        return "Hello this is SpringWebFlux";
    }


}
