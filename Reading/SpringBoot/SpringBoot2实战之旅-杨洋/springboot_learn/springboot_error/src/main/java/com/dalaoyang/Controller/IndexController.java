package com.dalaoyang.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.Controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/28
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        Map map = null;
        return map.toString();
    }
}
