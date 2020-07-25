package com.dalaoyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email 397600342@qq.com
 * @date 2018/3/14
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String testThymeleaf(ModelMap modelMap){
        modelMap.addAttribute("msg", "Hello dalaoyang , this is thymeleaf");
        return "thymeleaf";
    }
}
