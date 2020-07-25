package com.dalaoyang.controller;

import com.dalaoyang.annotation.DoneTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/9/9
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    @DoneTime(param = "IndexController")
    public String index(){
        System.out.println("方法执行");
        return "hello dalaoyang";
    }

    @GetMapping("/index2")
    public String index2(){
        System.out.println("方法2执行");
        return "hello dalaoyang";
    }
}
