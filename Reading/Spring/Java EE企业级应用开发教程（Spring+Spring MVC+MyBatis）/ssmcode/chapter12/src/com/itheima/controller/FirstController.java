package com.itheima.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 控制器类
 */
@Controller
@RequestMapping(value="/hello")
public class FirstController{
	@RequestMapping(value="/firstController")
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		// 向模型对象中添加数据
		model.addAttribute("msg", "这是我的第一个Spring MVC程序");
		// 返回视图页面
		return "first";
	}
}
