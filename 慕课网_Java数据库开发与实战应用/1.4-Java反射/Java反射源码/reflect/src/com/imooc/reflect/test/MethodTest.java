package com.imooc.reflect.test;

import java.lang.reflect.Method;

import org.junit.Test;

public class MethodTest {

	@Test
	// 测试公有的方法
	public void demo1() throws Exception{
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		// 实例化:
		Person person = (Person) class1.newInstance();
		// 获得公有的方法
		Method method = class1.getMethod("eat");
		// 执行该方法:
		method.invoke(person); // person.eat();
	}
	
	@Test
	// 测试私有的方法
	public void demo2() throws Exception{
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		// 实例化:
		Person person = (Person) class1.newInstance();
		// 获得方法:
		Method method = class1.getDeclaredMethod("run");
		// 设置私有的属性的访问权限:
		method.setAccessible(true);
		// 执行该方法:
		method.invoke(person, null);
	}
	
	@Test
	// 测试私有的方法带参数
	public void demo3() throws Exception{
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		// 实例化:
		Person person = (Person) class1.newInstance();
		// 获得该方法:
		Method method = class1.getDeclaredMethod("sayHello", String.class);
		// 设置访问权限:
		method.setAccessible(true);
		// 执行:
		Object obj = method.invoke(person, "Tom");
		System.out.println(obj);
	}
}
