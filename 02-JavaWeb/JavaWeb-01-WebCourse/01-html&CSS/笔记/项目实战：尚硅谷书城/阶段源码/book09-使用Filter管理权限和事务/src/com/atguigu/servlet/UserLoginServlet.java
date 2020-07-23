package com.atguigu.servlet;

import javax.servlet.http.HttpServlet;

import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//定义一个userService处理用户的业务
	private UserService userService;
	
	public UserLoginServlet() {
		super();
		// 初始化userService
		userService = new UserServiceImpl();
		
	}

//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		// 设置post乱码解决，设置请求参数的字符集为UTF-8
//		request.setCharacterEncoding("UTF-8");
//		// 获取用户名
//		String username = request.getParameter("username");
//		// 获取用户登录的密码
//		String password = request.getParameter("password");
//		
//		// 根据用户名密码根据系统
//		User user = userService.loginByUsernameAndPassword(new User(0, username, password, ""));
//		// 如果user不为null，说明登录成功！
//		if (user != null) {
//			System.out.println("[" + username +  "]用户登录成功！跳转去登录成功页面login_success.jsp");
//			// 登录成功之后。转发到登录成功 页面
//			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
//		} else {
//			//如果user == null ,说明登录失败，用户名错误，或者密码错误。
//			request.setAttribute("msg", "登录失败，用户名或密码错误！");
//			request.setAttribute("username", username);
//			System.out.println("[" + username + "]用户登录失败！跳转去登录页面login.jsp");
//			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);;
//		}
//		
//	}

}
