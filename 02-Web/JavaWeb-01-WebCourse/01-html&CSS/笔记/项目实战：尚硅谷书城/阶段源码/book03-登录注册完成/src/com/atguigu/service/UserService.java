package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {

	/**
	 * 保存用户的信息
	 * 
	 * @return 返回true说明注册成功<br/>
	 *         返回false说明注册失败！！
	 */
	public boolean saveUser(User user);

	/**
	 * 登录
	 * 
	 * @param user
	 *            登录用户的信息
	 * @return 返回的是当前登录的user对象<br/>
	 *         如果 用户名或者密码错误，返回null
	 */
	public User loginByUsernameAndPassword(User user);

	/**
	 * 检查 用户名是否存在
	 * 
	 * @param username
	 * @return 返回true表示用户名存在.<br/>
	 *         返回false表示用户名不存在
	 */
	public boolean existsUsername(String username);
}
