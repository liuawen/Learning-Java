package com.atguigu.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;

public class BookDaoTest {

	private static BookDao bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("这是方法之前");
		bookDao = new BookDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("这是测试方法之后");
	}

	@Test
	public void testSave() throws Exception {
		bookDao.save(new Book(0, "1234123", "大神是怎么样练成的", 12.12, 12, 232, null));
	}

	@Test
	public void testDeleteById() throws Exception {
		System.out.println(bookDao.deleteById(16));
	}

	@Test
	public void testUpdate() throws Exception {
		System.out.println(bookDao.update(new Book(15, "xxxx", "xxxx", 88, 88, 88, null)));
	}

	@Test
	public void testQueryAllBook() throws Exception {
		System.out.println(bookDao.queryAllBook());
	}

}
