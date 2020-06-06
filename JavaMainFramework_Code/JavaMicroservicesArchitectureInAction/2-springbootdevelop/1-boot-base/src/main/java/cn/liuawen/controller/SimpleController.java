package cn.liuawen.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 */
@Controller
@EnableAutoConfiguration
public class SimpleController {
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "www.liuawen.cn";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class, args);
    }
}
