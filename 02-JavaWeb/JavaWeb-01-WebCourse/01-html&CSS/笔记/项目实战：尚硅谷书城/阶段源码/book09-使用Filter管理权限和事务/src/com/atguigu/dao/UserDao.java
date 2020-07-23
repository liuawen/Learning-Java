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
	 * @throws Exception 
	 */
	public int saveUser(User user) throws Exception;

	/**
	 * 根据用户名和密码搜索用户
	 * 
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public User findUserByUsernameAndPassword(User user) throws Exception;

	/**
	 * 根据用户名搜索用户
	 * 
	 * @param username
	 *            用户名
	 * @return 如果用户名存在，返回查询的用户信息。<br/>
	 *         如果用户名不存在。返回null
	 * @throws Exception 
	 */
	public User checkUserName(String username) throws Exception;
}
