package com.atguigu.spring.tx.service;

import java.util.List;

public interface Cashier {

	/**
	 * 去结账
	 * 
	 * @param userId
	 * @param isbns
	 */
	void checkout(int userId, List<String> isbns);
}
