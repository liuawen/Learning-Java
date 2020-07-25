package com.dalaoyang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email 397600342@qq.com
 * @date 2018/3/13
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "hi dalaoyang";
    }
}
