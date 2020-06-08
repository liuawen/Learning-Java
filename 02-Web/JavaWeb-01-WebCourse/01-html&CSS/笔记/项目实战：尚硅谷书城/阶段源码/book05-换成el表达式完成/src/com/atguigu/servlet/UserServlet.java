package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.Utils;

/**
 * 用户模块
 * 
 * @author wzg
 *
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public UserServlet() {
		super();
		userService = new UserServiceImpl();
	}

	/**
	 * 注册用户的操作
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取注册的用户名
//		String username = request.getParameter("username");
		// 获取用户注册的密码
//		String password = request.getParameter("password");
		// 获取用户注册的邮箱号
//		String email = request.getParameter("email");
		// 获取用户注册的验证码
		String code = request.getParameter("code");
		
		// 把传递过来的参数赋值到javaBean对象中
		User t = new User();
		Utils.copyParameter2Bean( request.getParameterMap(), t );
		
		
		// 我们假设我们生成的验证码是abcde
		if ("abcde".equals(code)) {
			// 判断用户名是否已经存在！
			boolean existsUsername = userService.existsUsername(t.getUsername());
			// 如果返回真说明 用户名已存在，
			if (existsUsername) {
				System.out.println("用户名已存在，注册失败");
				// 把错误的信息带回到jsp页面回显
				request.setAttribute("msg", "用户名已存在，注册失败");
				request.setAttribute("username", t.getUsername());
				request.setAttribute("email", t.getEmail());

				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			} else {
				// 注册用户信息
				boolean result = userService.saveUser(t);
				// 如果返回true说明注册成功
				if (result) {
					// 如果注册成功。跳转到注册成功页面
					request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,
							response);
				} else {
					System.out.println("用户注册失败");

					// 把错误的信息带回到jsp页面回显
					request.setAttribute("msg", "用户注册失败");
					request.setAttribute("username", t.getUsername());
					request.setAttribute("email", t.getEmail());

					request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,
							response);

				}
			}
		} else {
			// 验证码错误，返回注册页面。并且提示错误
			System.out.println("验证码错误！");

			request.setAttribute("msg", "验证码错误！");
			request.setAttribute("username", t.getUsername());
			request.setAttribute("email", t.getEmail());

			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

	/**
	 * 登录的操作
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户名
//		String username = request.getParameter("username");
		// 获取用户登录的密码
//		String password = request.getParameter("password");
		
//		Map<String, String[]>params = request.getParameterMap();
//		for ( String key : params.keySet() ) {
//			System.out.println("参数名->" + key);
//			String[] values = params.get(key);
//			for (String v : values) {
//				System.out.println("参数值：" + v);
//			}
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		}
		
		User t = new User();
		com.atguigu.util.Utils.copyParameter2Bean(request.getParameterMap(), t);
		

		// 根据用户名密码根据系统
		User user = userService.loginByUsernameAndPassword(t);
		// 如果user不为null，说明登录成功！
		if (user != null) {
			
			System.out.println("[" + user.getUsername() + "]用户登录成功！跳转去登录成功页面login_success.jsp");
			// 登录成功之后。转发到登录成功 页面
			request.getRequestDispatcher("/pages/user/login_success.jsp")
					.forward(request, response);
		} else {
			// 如果user == null ,说明登录失败，用户名错误，或者密码错误。
			request.setAttribute("msg", "登录失败，用户名或密码错误！");
			request.setAttribute("username", t.getUsername());
			System.out.println("[" + t.getUsername() + "]用户登录失败！跳转去登录页面login.jsp");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

}
