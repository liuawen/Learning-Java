package com.atguigu.bookstore.service;

import com.atguigu.bookstore.dao.AccountDAO;
import com.atguigu.bookstore.dao.impl.AccountDAOIml;
import com.atguigu.bookstore.domain.Account;

public class AccountService {
	
	private AccountDAO accountDAO = new AccountDAOIml();
	
	public Account getAccount(int accountId){
		return accountDAO.get(accountId);
	}
	
}
