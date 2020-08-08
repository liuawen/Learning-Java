package com.atguigu.test;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;

public class UserDaoTest {

	@Test
	public void testSaveUser() throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.saveUser(new User(0, "abc", "asdfasd", "asdfafds@qq.com"));
	}

	@Test
	public void testFindUserByUsernameAndPassword() throws Exception {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findUserByUsernameAndPassword(new User(0, "abc", "asdfasd", ""));
		System.out.println(user);
		user = userDao.findUserByUsernameAndPassword(new User(0, "admin", "admin", ""));
		System.out.println(user);
		user = userDao.findUserByUsernameAndPassword(new User(0, "adsfadsf", "admin", ""));
		System.out.println(user);
	}

	@Test
	public void testCheckUserName() throws Exception {
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.checkUserName("admin"));
		System.out.println(userDao.checkUserName("ddd"));
	}

}
