package com.itheima.factorybean;
import org.springframework.context.ApplicationContext;
import 
    org.springframework.context.support.ClassPathXmlApplicationContext;
import com.itheima.jdk.UserDao;
// 测试类
public class ProxyFactoryBeanTest {
	public static void main(String args[]) {
	   String xmlPath = "com/itheima/factorybean/applicationContext.xml";
	   ApplicationContext applicationContext = 
                                 new ClassPathXmlApplicationContext(xmlPath);
	   // 从Spring容器获得内容
	   UserDao userDao = 
                       (UserDao) applicationContext.getBean("userDaoProxy");
	   // 执行方法
	   userDao.addUser();
	   userDao.deleteUser();
	}
}
