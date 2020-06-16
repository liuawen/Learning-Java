package cn.liuawen.controller;

import cn.liuawen.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 * @RestController 一旦使用  所有方法都将以Restful风格展示
 * 这种做法未必适合于SpringBoot项目  控制器跳转到显示层
 * 客户端 显示层  控制器  业务逻辑层 数据层 数据库
 * 而Restful是SpringCLoud技术的实现关键
 * <p>
 * Restful架构中请求
 * 可以结合HTTP请求 GET POST DELETE PUT  处理不同类型的用户请求
 */
@RestController
//建立控制器 以所有的路径以Restful形式运行
public class MessageController {
    @Autowired
    private MessageUtil messageUtil;
    @GetMapping("/info")
    public Object info(){
        return this.messageUtil.getInfo();
    }
    @Resource
    private MessageSource messageSource; // 自动注入此资源对象
    @GetMapping("/message")
    public Object message() {
        Map<String,String> map = new HashMap<String,String>() ;
        map.put("welcome.url", this.messageSource.getMessage("welcome.url", null, Locale.getDefault())) ;
        map.put("welcome.msg", this.messageSource.getMessage("welcome.msg", new Object[] {"菜鸡文"}, new Locale("en","US"))) ;
        return map ;
    }

   /* @Autowired
    private MessageSource messageSource;//自动注入此对象资源
    @GetMapping("/message")
    public Object message(){
        Map<String,String> map = new HashMap<String, String>();
//        this.messageSource.getMessage()  //进行资源的读取
        map.put("welcome.url",this.messageSource.
                getMessage("welcome.url",null, Locale.getDefault()));
        map.put("welcome.msg",this.messageSource.
                getMessage("welcome.msg",new Object[]{"菜鸡文"},Locale.getDefault()));
        return map;
    }*/
/*    @GetMapping("/object")
    public Object object(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> map = new HashMap<String, String>();
        map.put("客户端IP地址", request.getRemoteAddr());
        map.put("客户端响应编码", response.getCharacterEncoding());
        map.put("SessionID", request.getSession().getId());
        map.put("项目真实路径",request.getServletContext().getRealPath("/"));
        //Map集合自动变为JSON格式
        return map;//以Restful风格返回
    }*/
    @GetMapping("/object")
    public Object object() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();			// 获取HttpServletRequest内置对象
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();			// 获取HttpServletResponse内置对象
        Map<String,String> map = new HashMap<String,String>() ;
        map.put("客户端IP地址", request.getRemoteAddr()) ;
        map.put("客户端响应编码", response.getCharacterEncoding()) ;
        map.put("SessionID", request.getSession().getId()) ;
        map.put("项目真实路径", request.getServletContext().getRealPath("/")) ;
        return map ; 					// 以Restful风格返回
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "hello";
    }

    @GetMapping("/echo")//只支持GET请求模式
    public String echo(String msg) {//接收msg参数
        return "【echo】" + msg;//信息处理后返回
    }
    //http://localhost:8080/echo
    //【echo】null

    //http://localhost:8080/echo?msg=hello
    //【echo】hello

    //SpringBoot支持Restful风格处理  参数的接收可以采用路径参数的形式完成
    @GetMapping("/sayHello/{message}")//只支持GET请求模式
    public String sayHello(@PathVariable("message") String msg) {//接收msg参数
        return "【echo】" + msg;//信息处理后返回
    }
    //地址传递参数
    //http://localhost:8080/sayHello/hello
    //【echo】hello
}
