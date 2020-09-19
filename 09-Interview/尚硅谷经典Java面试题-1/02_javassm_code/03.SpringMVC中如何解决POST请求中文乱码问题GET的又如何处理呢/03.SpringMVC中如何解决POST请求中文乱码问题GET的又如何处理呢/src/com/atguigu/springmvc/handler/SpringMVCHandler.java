package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.springmvc.entities.Employee;

@Controller
public class SpringMVCHandler {
	
	public static final String SUCCESS="success";

	//1.SpringMVC中如何解决POST请求中文乱码问题，GET的又如何处理呢
	
	/*
	 * ★测试入参为POJO
	 * Spring MVC会按请求参数名和 POJO属性名进行自动匹配，
	 * 		    自动为该对象填充属性值。支持级联属性
	 */
	@RequestMapping("/testPOJO")
	public String testPOJO(Employee employee) {
		System.out.println("员工的信息是："+employee);
		return SUCCESS;
	}
}
