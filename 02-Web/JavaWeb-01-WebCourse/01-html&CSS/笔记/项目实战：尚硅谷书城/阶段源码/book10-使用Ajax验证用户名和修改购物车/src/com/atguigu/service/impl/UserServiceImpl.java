package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

/**
 * 用户模块业务的具体实现类
 * 
 * @author wzg
 *
 */
public class UserServiceImpl implements UserService {

	// 在userService中保存一个dao的引用。用来操作数据库
	protected UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean saveUser(User user) throws Exception {
		// 注册用户信息
		int updateCount = userDao.saveUser(user);
		System.out.println("执行业务的其他操作");
		return updateCount > 0 ? true : false;
	}

	@Override
	public User loginByUsernameAndPassword(User user) throws Exception {
		// 调用userdao操作数据库查找用户信息
		return userDao.findUserByUsernameAndPassword(user);

	}

	@Override
	public boolean existsUsername(String username) throws Exception {
		// 调用userdao根据用户名搜索用户信息
		User user = userDao.checkUserName(username);
		// 如果用户不存，则返回false
		if (user == null) {
			return false;
		}
		// 用户存在，返回true
		return true;
	}

}
