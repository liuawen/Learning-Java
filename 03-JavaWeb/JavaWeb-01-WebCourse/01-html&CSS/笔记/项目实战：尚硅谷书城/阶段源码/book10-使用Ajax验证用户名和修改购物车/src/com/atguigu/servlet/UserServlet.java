package com.atguigu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.Utils;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

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
	 * 用户注销方法
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 移除Session对象中的用户信息
		request.getSession().removeAttribute("user");
		// 然后重定向到登录页面。或首页
		response.sendRedirect(request.getContextPath());
	}

	public void existsUsername(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		// 获取用户名
		String username = request.getParameter("username");
		// 用户名不能为空
		if ("".equals(username)) {
			return;
		}
		
		// 判断用户名是否存在
		boolean existsUsername = userService.existsUsername(username);
		// 返回用户是否存在
		Map<String, Integer> result = new HashMap<String, Integer>();
		// 如果用户存在，返回result 为1,如果用户不存在。result 返回0
		if (existsUsername) {
			result.put("result", 1);
		} else {
			result.put("result", 0);
		}
		// 生成Gson对象，用于把map转换成为json字符串返回
		Gson gson = new Gson();
		String responseStr = gson.toJson(result);
		response.getWriter().write(responseStr);
	}

	/**
	 * 注册用户的操作
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception,
			IOException {

		// 把传递过来的参数赋值到javaBean对象中
		User t = new User();
		Utils.copyMap2Bean(request.getParameterMap(), t);

		String code = request.getParameter("code");
		// 获取kaptcha的验证码
		String kaptchaToken = (String) request.getSession().getAttribute(
				Constants.KAPTCHA_SESSION_KEY);
		// 移除验证码，确保第二次请求匹配不上
		request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (kaptchaToken == null) {
			kaptchaToken = "";
		}
		System.out.println("验证码：" + kaptchaToken);
		System.out.println("code：" + code);
		// 我们假设我们生成的验证码是abcde
		if (kaptchaToken.equals(code)) {
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
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception,
			IOException {

		User t = new User();
		Utils.copyMap2Bean(request.getParameterMap(), t);

		// 根据用户名密码根据系统
		User user = userService.loginByUsernameAndPassword(t);
		// 如果user不为null，说明登录成功！
		if (user != null) {
			// 把用户添加到Session对象中
			request.getSession().setAttribute("user", user);

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
