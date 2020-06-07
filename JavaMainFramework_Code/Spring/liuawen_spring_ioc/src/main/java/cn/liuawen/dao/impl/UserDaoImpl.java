package cn.liuawen.dao.impl;

import cn.liuawen.dao.UserDao;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 */
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建...");
    }
    public void init(){
        System.out.println("初始化方法...");
    }
    public void destroy(){
        System.out.println("销毁方法...");
    }
    @Override
    public void say() {
        System.out.println("hello");
    }
}
