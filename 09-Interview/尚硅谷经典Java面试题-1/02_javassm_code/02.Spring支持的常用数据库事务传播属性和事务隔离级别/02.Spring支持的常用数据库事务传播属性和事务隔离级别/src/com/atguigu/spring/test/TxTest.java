package com.atguigu.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.tx.dao.BookShopDao;
import com.atguigu.spring.tx.service.BookShopService;
import com.atguigu.spring.tx.service.Cashier;

class TxTest {
	
	//创建IOC容器对象
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-tx.xml");
	
	@Test
	void testBookShopDao() {
		//获取BookDao
		BookShopDao bookShopDao = (BookShopDao) ioc.getBean("bookShopDao");
		double bookPrice = bookShopDao.getBookPriceByIsbn("1001");
		System.out.println(bookPrice);
		//更新图书的库存
		bookShopDao.updateBookStock("1001");
		//更新账户的余额
		bookShopDao.updateAccountBalance(1, bookPrice);
	}
	
	@Test
	void testBookShopService() {
		BookShopService bookShopService = (BookShopService) ioc.getBean("bookShopService");
		bookShopService.purchase(1, "1001");
	}
	
	@Test
	void testCashier() {
		Cashier cashier = (Cashier) ioc.getBean("cashier");
		//创建List
		List<String> isbns = new ArrayList<>();
		isbns.add("1001");
		isbns.add("1002");
		//去结账
		cashier.checkout(1, isbns);
	}

}
