package com.itheima.jdk;

import org.springframework.stereotype.Repository;

// 目标类
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	public void addUser() {
//		int i = 10/0;
		System.out.println("添加用户");
	}
	public void deleteUser() {
		System.out.println("删除用户");
	}
}
