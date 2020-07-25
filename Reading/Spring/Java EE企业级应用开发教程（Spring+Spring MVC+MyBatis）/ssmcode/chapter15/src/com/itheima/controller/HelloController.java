package com.itheima.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {
	/**
	 * 页面跳转
	 */
	@RequestMapping("/hello")
	public String Hello() {
         System.out.println("Hello!");
	    return "success";
	}
}
