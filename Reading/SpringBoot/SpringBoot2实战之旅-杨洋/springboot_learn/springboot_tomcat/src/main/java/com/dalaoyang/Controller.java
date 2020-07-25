package com.dalaoyang;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @project springboot_learn
 * @package com.dalaoyang
 * @email yangyang@dalaoyang.cn
 * @date 2018/8/1
 */
@RestController
public class Controller  {

    @GetMapping("/")
    public String index(){
        return "Hello , dalaoyang ";
    }
}
