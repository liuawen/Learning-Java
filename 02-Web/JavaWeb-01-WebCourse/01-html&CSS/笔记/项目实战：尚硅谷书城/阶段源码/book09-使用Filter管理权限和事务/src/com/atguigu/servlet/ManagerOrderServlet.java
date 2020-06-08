package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Order;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

public class ManagerOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService;

	public ManagerOrderServlet() {
		orderService = new OrderServiceImpl();
	}

	/**
	 * 所有订单
	 */
	protected void orders(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {

		User user = (User) request.getSession().getAttribute("user");
		// 用户未登录，需要先登录
		if (user == null) {
			// 如果用户没有登录，重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
		} else {
			// 查询用户的订单信息
			List<Order> orders = orderService.queryAllOrders();
			// 设置订单到域对象中
			request.setAttribute("orders", orders);
			System.out.println(orders);
			// 转发到订单页面
			request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,
					response);
		}
	}

	/**
	 * 确认发货
	 */
	protected void sendOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		// 获取发货的订单号
		String orderId = request.getParameter("orderId");
		// 发货
		orderService.sendOrder(orderId);
		
		// 重定向到订单页面
		response.sendRedirect(request.getHeader("referer"));
	}

}
