package com.atguigu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.Utils;
import com.google.gson.Gson;

/**
 * 购物车Servlet程序
 */
public class CartServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private BookService bookService;
	

	public CartServlet() {
		bookService = new BookServiceImpl();
	}

	/**
	 * 添加到购物车
	 */
	protected void addItem(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 生成一个新的购物车，放到Session对象中
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 获取图书 的id
		int id = Utils.parseInt(request.getParameter("id"), 0);
		// 查找图书
		Book book = bookService.findBookById(id);
		// 添加到购物车中
		cart.addItem(book);
		// 添加商品名到Session对象中。
		request.getSession().setAttribute("last_product", book.getName());
		// 打印测试
		System.out.println(cart);
		// 获取请求头referer，这是引用页
		String referer = request.getHeader("referer");
		// 重定向到原来的页面。
		response.sendRedirect(referer);
	}
	
	/**
	 * Ajax版--添加到购物车
	 */
	protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response)
			throws Exception, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 生成一个新的购物车，放到Session对象中
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 获取图书 的id
		int id = Utils.parseInt(request.getParameter("id"), 0);
		// 查找图书
		Book book = bookService.findBookById(id);
		// 添加到购物车中
		cart.addItem(book);
		// 添加商品名到Session对象中。
		request.getSession().setAttribute("last_product", book.getName());
		// 打印测试
		System.out.println(cart);
		// 创建一个map用于返回结果
		Map<String, Object>result = new HashMap<String, Object>();
		result.put("result", 0);
		result.put("totalCount", cart.getTotalCount());
		result.put("last_product", book.getName());
	
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(result));
	}

	/**
	 * 从购物车删除商品
	 */
	protected void deleteItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取删除的商品编号
		int id = Utils.parseInt(request.getParameter("id"), 0);
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 生成一个新的购物车，放到Session对象中
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 删除商品
		cart.deleteItem(id);
		// 获取请求头referer，这是引用页
		String referer = request.getHeader("referer");
		// 重定向到原来的页面。
		response.sendRedirect(referer);
	}
	
	/**
	 * 清空购物车商品
	 */
	protected void clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 生成一个新的购物车，放到Session对象中
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 清空商品
		cart.clear();
		// 获取请求头referer，这是引用页
		String referer = request.getHeader("referer");
		// 重定向到原来的页面。
		response.sendRedirect(referer);
	}

	/**
	 * 更新购物车商品数量
	 */
	protected void updateItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取删除的商品编号
		int id = Utils.parseInt(request.getParameter("id"), 0);
		// 获取商品数量
		int count = Utils.parseInt(request.getParameter("count"), 1);
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 生成一个新的购物车，放到Session对象中
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 删除商品
		cart.updateItem(id, count);
		// 获取请求头referer，这是引用页
		String referer = request.getHeader("referer");
		// 重定向到原来的页面。
		response.sendRedirect(referer);
	}
	
	/**
	 * ajax版--更新购物车商品数量
	 */
	protected void ajaxUpdateItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取删除的商品编号
		int id = Utils.parseInt(request.getParameter("id"), 0);
		// 获取商品数量
		int count = Utils.parseInt(request.getParameter("count"), 1);
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 生成一个新的购物车，放到Session对象中
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 删除商品
		double item_totalMoney = cart.updateItem(id, count);
		// 创建一个Map返回要显示的内容
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("item_totalMoney", ""+item_totalMoney);
		result.put("cart_totalMoney", cart.getTotalMoney());
		result.put("cart_totalCount", cart.getTotalCount());
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(result));
	}

}
