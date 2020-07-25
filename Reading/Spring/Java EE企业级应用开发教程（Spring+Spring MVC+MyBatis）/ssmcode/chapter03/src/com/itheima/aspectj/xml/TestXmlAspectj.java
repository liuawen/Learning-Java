package com.itheima.aspectj.xml;
import org.springframework.context.ApplicationContext;
import 
    org.springframework.context.support.ClassPathXmlApplicationContext;
import com.itheima.jdk.UserDao;
// 测试类
public class TestXmlAspectj {
	public static void main(String args[]) {
		String xmlPath = 
                         "com/itheima/aspectj/xml/applicationContext.xml";
		ApplicationContext applicationContext = 
                          new ClassPathXmlApplicationContext(xmlPath);
		// 1 从spring容器获得内容
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// 2 执行方法
		userDao.addUser();
	}
}
