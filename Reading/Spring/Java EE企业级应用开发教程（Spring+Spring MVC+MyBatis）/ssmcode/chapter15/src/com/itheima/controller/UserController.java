package com.itheima.controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itheima.po.User;
@Controller
public class UserController {
	/**
	 * 向用户登录页面跳转
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model,HttpSession session) {
	    // 获取用户名和密码
	    String username = user.getUsername();
	    String password = user.getPassword();
	    // 此处模拟从数据库中获取用户名和密码后进行判断
	    if(username != null && username.equals("xiaoxue")
	    		&& password != null && password.equals("123456")){
	         // 将用户对象添加到Session
	     	session.setAttribute("USER_SESSION", user);
	     	// 重定向到主页面的跳转方法
	    	    return "redirect:main";
	    }
	    model.addAttribute("msg", "用户名或密码错误，请重新登录！");
	    return "login";
	}
	/**
	 * 向用户主页面跳转
	 */
	@RequestMapping(value="/main")
	public String toMain() {
		return "main";
	}
    /**
     * 退出登录
     */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除Session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:login";
	}
}
