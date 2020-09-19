package com.atguigu.spring.tx.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atguigu.spring.tx.dao.BookShopDao;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBookPriceByIsbn(String isbn) {
		// 写sql语句
		String sql = "select price from book where isbn = ?";
		// 调用JdbcTemplate中的queryForObject方法
		Double bookPrice = jdbcTemplate.queryForObject(sql, Double.class, isbn);
		return bookPrice;
	}

	@Override
	public void updateBookStock(String isbn) {
		// 写sql语句
		String sql = "update book_stock set stock = stock - 1 where isbn = ?";
		// 调用JdbcTemplate中的update方法
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateAccountBalance(int userId, double bookPrice) {
		// 写sql语句
		String sql = "update account set balance = balance - ? where id = ?";
		// 调用JdbcTemplate中的update方法
		jdbcTemplate.update(sql, bookPrice, userId);
	}

}
