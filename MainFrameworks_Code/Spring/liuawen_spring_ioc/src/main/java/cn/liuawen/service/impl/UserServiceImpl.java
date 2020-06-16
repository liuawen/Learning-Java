package cn.liuawen.service.impl;

import cn.liuawen.dao.UserDao;
import cn.liuawen.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-08
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;


/*
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    //去Spring配置告诉 我构造
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl创建...");
    }

    @Override
    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao =(UserDao) app.getBean("userDao");
        userDao.save();
    }
}
