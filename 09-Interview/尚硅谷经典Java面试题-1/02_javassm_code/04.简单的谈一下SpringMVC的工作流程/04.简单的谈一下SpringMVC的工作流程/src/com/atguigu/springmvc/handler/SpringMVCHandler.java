package com.atguigu.springmvc.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.entities.Department;
import com.atguigu.springmvc.entities.Employee;

@Controller
public class SpringMVCHandler {
	
	public static final String SUCCESS="success";

	//1.简单的谈一下SpringMVC的工作流程
	
	//处理模型数据方式一：将方法的返回值设置为ModelAndView
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		//1.创建ModelAndView对象
		ModelAndView mav = new ModelAndView();
		//2.设置模型数据，最终会放到request域中
		mav.addObject("user", "admin");
		//3.设置视图
		mav.setViewName("success");
		return mav;
	}
	/*
	 * ★处理模型数据方式二：方法的返回值仍是String类型，在方法的入参中传入Map、Model或者ModelMap
	 * 	不管将处理器方法的返回值设置为ModelAndView还是在方法的入参中传入Map、Model或者ModelMap，
	 *  SpringMVC都会转换为一个ModelAndView对象
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String , Object> map) {
		//向Map中添加模型数据，最终会自动放到request域中
		map.put("user", new Employee(1, "韩总", "hybing@atguigu.com", new Department(101, "教学部")));
		return SUCCESS;
	}
	
}
