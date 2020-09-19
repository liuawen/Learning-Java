package com.atguigu.spring.tx.dao;

public interface BookShopDao {

	/**
	 * 根据书号查询图书的价格
	 * 
	 * @param isbn
	 * @return
	 */
	double getBookPriceByIsbn(String isbn);

	/**
	 * 根据书号更新图书的库存，每次只买一本图书
	 * 
	 * @param isbn
	 */
	void updateBookStock(String isbn);

	/**
	 * 根据用户的id和图书的价格更新用户的账户余额
	 * 
	 * @param userId
	 * @param bookPrice
	 */
	void updateAccountBalance(int userId, double bookPrice);
}
