package com.itheima.jdbc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import 
org.springframework.context.support.ClassPathXmlApplicationContext;
//测试类
public class TransactionTest {
	@Test
	public void xmlTest(){
		ApplicationContext applicationContext = 
		   new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = 
            (AccountDao)applicationContext.getBean("accountDao");
		// 调用实例中的转账方法
		accountDao.transfer("Jack", "Rose", 100.0);
	    // 输出提示信息
	    System.out.println("转账成功！");
	}
	
	@Test
	public void annotationTest(){
	    ApplicationContext applicationContext = 
	new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao = 
	(AccountDao)applicationContext.getBean("accountDao");
	    // 调用实例中的转账方法
	    accountDao.transfer("Jack", "Rose", 100.0);
	    // 输出提示信息
	    System.out.println("转账成功！");
	}

}
