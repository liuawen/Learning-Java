package com.itheima.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 控制器类
 */
public class FirstController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			               HttpServletResponse response)  {
         // 创建ModelAndView对象
		ModelAndView mav = new ModelAndView();
         // 向模型对象中添加数据
		mav.addObject("msg", "这是我的第一个Spring MVC程序");
         // 设置逻辑视图名
		mav.setViewName("/WEB-INF/jsp/first.jsp");
         // 返回ModelAndView对象
		return mav;
	}
}
