package com.itheima.annotation;
import org.springframework.context.ApplicationContext;
import 
   org.springframework.context.support.ClassPathXmlApplicationContext;
public class AnnotationAssembleTest {
	public static void main(String[] args) {
		// 定义配置文件路径
		String xmlPath = "com/itheima/annotation/beans6.xml";
		// 加载配置文件
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(xmlPath);
		// 获取UserController实例
		UserController userController = 
		  (UserController) applicationContext.getBean("userController");
		// 调用UserController中的save()方法
		userController.save();
	}
}  
