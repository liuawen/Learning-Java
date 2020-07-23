package com.atguigu.test;

import org.junit.Test;

import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * 购物车测试
 * 
 * @author wzg
 *
 */
public class CartTest {

	private Cart cart = new Cart();
	private BookService bookService = new BookServiceImpl();

	@Test
	public void cartTest() throws Exception {
		// 添加商品
		cart.addItem(bookService.findBookById(1));
		// 添加商品
		cart.addItem(bookService.findBookById(1));
		// 添加商品
		cart.addItem(bookService.findBookById(2));
		System.out.println(cart);

		// 测试删除
		cart.deleteItem(2);
		System.out.println(cart);
		
		// 修改个数
		cart.updateItem(1, 5);
		System.out.println(cart);
		
		// 清空购物车
		cart.clear();
		System.out.println(cart);
	}

}
