package cn.liuawen.demo;

import cn.liuawen.dao.UserDao;
import cn.liuawen.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 */
public class UserDemo {
   @Test
   public void test1(){
      ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
      ClassPathXmlApplicationContext app2 = new ClassPathXmlApplicationContext("applicationContext.xml");

      UserDao userDao =(UserDao) app.getBean("userDao");
      UserDao userDao2 =(UserDao) app.getBean("userDao");
      userDao.say();
      ((ClassPathXmlApplicationContext)app).close();

//      app2.close();
   }
}
