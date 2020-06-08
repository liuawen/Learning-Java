package com.atguigu.servlet;

import javax.servlet.http.HttpServlet;

import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * 用户注册的Servlet
 */
public class RegistUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 持 有一个 userService业务的操作接口，来操作业务
	private UserService userService;

	public RegistUserServlet() {
		super();
		// 实现一个userService实例
		userService = new UserServiceImpl();
	}

}
