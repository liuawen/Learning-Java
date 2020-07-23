package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

public class ClientOrderServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private OrderService orderService;

	public ClientOrderServlet() {
		super();
		orderService = new OrderServiceImpl();
	}

	/**
	 * 创建订单
	 */
	protected void createOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		User user = (User) request.getSession().getAttribute("user");
		// 用户未登录，需要先登录
		if (user == null) {
			// 如果用户没有登录，重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
		} else {
			// 获取购物车
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			// 生成订单
			String orderId = orderService.saveOrder(cart, user.getId());
			// 把订单号保存到
			request.getSession().setAttribute("orderId", orderId);
			// 重定向到生成订单成功页面
			response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
		}
	}

	/**
	 * 我的订单
	 */
	protected void myOrders(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		User user = (User) request.getSession().getAttribute("user");
		// 用户未登录，需要先登录
		if (user == null) {
			// 如果用户没有登录，重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
		} else {
			// 查询用户的订单信息
			List<Order> orders = orderService.queryMyOrders(user.getId());
			// 设置订单到域对象中
			request.setAttribute("myOrders", orders);
			// 转发到订单页面
			request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
		}
	}

	/**
	 * 确认收货
	 */
	protected void receivedOrder(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		// 获取发货的订单号
		String orderId = request.getParameter("orderId");
		// 发货
		orderService.receivedOrder(orderId);
		
		// 重定向到订单页面
		response.sendRedirect(request.getHeader("referer"));
	}
}
