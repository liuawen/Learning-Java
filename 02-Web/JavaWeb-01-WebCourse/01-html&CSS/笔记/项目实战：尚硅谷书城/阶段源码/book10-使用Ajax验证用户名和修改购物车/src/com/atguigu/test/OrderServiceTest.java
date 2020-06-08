package com.atguigu.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.service.impl.OrderServiceImpl;

public class OrderServiceTest {

	private static OrderService orderService;
	private static BookService bookService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderService = new OrderServiceImpl();
		bookService = new BookServiceImpl();
	}

	@Test
	public void testSaveOrder() throws Exception {

		// 创建一个购物车
		Cart cart = new Cart();
		cart.addItem(bookService.findBookById(1));
		cart.addItem(bookService.findBookById(1));
		cart.addItem(bookService.findBookById(2));

		// 测试生成订单
		orderService.saveOrder(cart, 1);
		orderService.saveOrder(cart, 2);

	}

	@Test
	public void testQueryMyOrders() throws Exception {
		// 测试查询我的订单
		System.out.println(orderService.queryMyOrders(1));
	}

	@Test
	public void testQueryOrderItems() throws Exception {
		// 测试查询订单项
		System.out.println(orderService.queryOrderItems("14809196891631"));
	}

	@Test
	public void testQueryAllOrders() throws Exception {
		// 测试所有订单查询
		System.out.println(orderService.queryAllOrders());
	}

	@Test
	public void testSendOrder() throws Exception {
		// 测试确认发货
		orderService.sendOrder("14809196891631");
	}

	@Test
	public void testReceivedOrder() throws Exception {
		// 测试确认收货
		orderService.receivedOrder("14809196891631");
	}

}
