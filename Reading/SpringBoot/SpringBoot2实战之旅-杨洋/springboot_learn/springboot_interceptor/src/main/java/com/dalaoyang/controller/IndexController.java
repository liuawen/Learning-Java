package com.dalaoyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/27
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("content","hi , dalaoyang !");
        return "index";
    }
}
