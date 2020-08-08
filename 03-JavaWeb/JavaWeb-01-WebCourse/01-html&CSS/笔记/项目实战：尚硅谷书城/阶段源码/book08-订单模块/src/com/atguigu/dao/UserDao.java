package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * 
 * @author wzg
 *
 */
public interface UserDao {
	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public int saveUser(User user);

	/**
	 * 根据用户名和密码搜索用户
	 * 
	 * @param user
	 * @return
	 */
	public User findUserByUsernameAndPassword(User user);

	/**
	 * 根据用户名搜索用户
	 * 
	 * @param username
	 *            用户名
	 * @return 如果用户名存在，返回查询的用户信息。<br/>
	 *         如果用户名不存在。返回null
	 */
	public User checkUserName(String username);
}
