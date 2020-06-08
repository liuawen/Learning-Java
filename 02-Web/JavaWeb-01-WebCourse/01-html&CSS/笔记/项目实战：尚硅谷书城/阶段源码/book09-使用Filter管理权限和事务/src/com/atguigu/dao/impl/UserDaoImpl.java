package com.atguigu.dao.impl;

import java.sql.SQLException;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;

/**
 * UserDAO具体的实现类
 * 
 * @author wzg
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public int saveUser(User user) throws Exception {
		// 要执行的sql
		String sql = "insert into t_user(`id`,`username`,`password`,`email`) values(null, ?, ?, ?)";
		// 调用baseDaoImpl执行
		return update(sql, user.getUsername(), user.getPassword(),
				user.getEmail());
	}

	@Override
	public User findUserByUsernameAndPassword(User user) throws Exception {
		// 要执行的sql
		String sql = "select id,username,password,email from t_user where username = ? and password = ?";
		// 调用BaseDaoImpl搜索
		return queryOne(sql, user.getUsername(), user.getPassword());
	}

	@Override
	public User checkUserName(String username) throws Exception {
		// 要执行的sql语句
		String sql = "select id,username,password,email from t_user where username = ?";
		// 调用BaseDaoImpl搜索
		return queryOne(sql, username);
	}

}
