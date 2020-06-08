package com.atguigu.test;

import org.junit.Test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

public class UserServiceTest {

	@Test
	public void testSaveUser() throws Exception {
		// 注册用户
		UserService userService = new UserServiceImpl();

		boolean result = userService.saveUser(new User(0, "bbj", "bbj",
				"bbj@qq.com"));
		if (result) {
			System.out.println("保存数据库成功");
		} else {
			System.out.println("数据库保存不成功");
		}

	}

	@Test
	public void testLoginByUsernameAndPassword() throws Exception {
		UserService userService = new UserServiceImpl();
		// 测试登录的业务
		User user = userService.loginByUsernameAndPassword(new User(0, "admin",
				"admin", ""));
		System.out.println(user);
		user = userService.loginByUsernameAndPassword(new User(0, "ad222min",
				"admin", ""));
		System.out.println(user);
	}

	@Test
	public void testExistsUsername() throws Exception {
		UserService userService = new UserServiceImpl();

		boolean result = userService.existsUsername("admin");
		if (result) {
			System.out.println("admin用户名已存在");
		} else {
			System.out.println("admin用户名不存在");
		}
		result = userService.existsUsername("dddd");
		if (result) {
			System.out.println("dddd用户名已存在");
		} else {
			System.out.println("dddd用户名不存在");
		}

	}

}
