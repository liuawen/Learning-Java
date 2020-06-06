package cn.liuawen.controller;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 * 小结：SpringBoot提倡的是一种简洁的开发模式
 * 可保证用户不被大量的配置文件和依赖关系所困扰
 * SpringBoot开发需要Maven或Gradle构建工具支持
 * SpringBoot使用一系列的注解来简化开发过程
 */
@Controller
//控制器注解
public class SimpleController {
    @RequestMapping("/")
    //访问映射路径
    @ResponseBody
    //Restful返回形式
    //控制器方法
    public String home(){
        //控制器返回信息
        return "www.liuawen.cn";
    }
}
