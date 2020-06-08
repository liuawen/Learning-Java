package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 解决post乱码问题，设置请求的参数字符集为UTf-8
		request.setCharacterEncoding("UTF-8");
		// 获取注册的用户名
		String username = request.getParameter("username");
		// 获取用户注册的密码
		String password = request.getParameter("password");
		// 获取用户注册的邮箱号
		String email = request.getParameter("email");
		// 获取用户注册的验证码
		String code = request.getParameter("code");
		// 我们假设我们生成的验证码是abcde
		if ("abcde".equals(code)) {
			// 判断用户名是否已经存在！
			boolean existsUsername = userService.existsUsername(username);
			// 如果返回真说明 用户名已存在，
			if (existsUsername) {
				System.out.println("用户名已存在，注册失败");
				response.sendRedirect("http://127.0.0.1:8080/book/pages/user/regist.html");
			} else {
				// 注册用户信息
				boolean result = userService.saveUser(new User(0, username,
						password, email));
				// 如果返回true说明注册成功
				if (result) {
					// 如果注册成功。跳转到注册成功页面
					request.getRequestDispatcher(
							"/pages/user/regist_success.html").forward(request,
							response);
				} else {
					System.out.println("用户注册失败");
					response.sendRedirect("http://127.0.0.1:8080/book/pages/user/regist.html");
				}
			}
		} else {
			// 验证码错误，返回注册页面。并且提示错误
			System.out.println("验证码错误！");
			response.sendRedirect("http://127.0.0.1:8080/book/pages/user/regist.html");
		}
	}

}
