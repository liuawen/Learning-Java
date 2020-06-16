package cn.liuawen.springboot_quick2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-15
 */
@RestController
public class QuickController {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "hello quick";
    }
}
