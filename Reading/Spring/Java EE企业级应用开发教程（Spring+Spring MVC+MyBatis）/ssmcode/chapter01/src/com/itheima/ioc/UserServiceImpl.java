package com.itheima.ioc;
public class UserServiceImpl implements UserService {
	// 声明UserDao属性
	private UserDao userDao;
	// 添加UserDao属性的setter方法，用于实现依赖注入
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	// 实现的接口中方法
	public void say() {
		//调用userDao中的say()方法，并执行输出语句
		this.userDao.say();
		System.out.println("userService say hello World !");
	}
}
