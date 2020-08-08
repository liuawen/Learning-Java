package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决post乱码问题，设置请求的参数字符集为UTf-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// action参数就可以用来判断是当前用户模块的哪一个操作。
		String action = request.getParameter("action");
		// 定义一个Method方法对象
		Method actionMethod;
		try {
			// 通过反射获取到与action字符串对应的操作方法
			actionMethod = getClass().getDeclaredMethod(action, HttpServletRequest.class,
					HttpServletResponse.class);
			// System.out.println(actionMethod);
			// 调用Method对象的invoke函数执行方法
			actionMethod.invoke(this, request, response);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
