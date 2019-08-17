package com.imooc.reflect.test;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldTest {

	@Test
	// 测试公有的属性
	public void demo1() throws Exception{
		// 获得Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		// 获得属性:
		Field field = class1.getField("name");
		// 操作属性:  p.name = "";
		Person p = (Person) class1.newInstance();
		field.set(p, "李四");// p.name = "李四";
		
		Object obj = field.get(p);
		System.out.println(obj);
		
	}
	
	@Test
	// 测试私有的属性
	public void demo2() throws Exception{
		// 获得Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		// 获得私有的属性
		Field field = class1.getDeclaredField("sex");
		// 操作属性:
		Person p = (Person) class1.newInstance();
		// 私有属性，需要设置一个可访问的权限:
		field.setAccessible(true);
		field.set(p, "男");
		// 获取值:
		Object obj = field.get(p);
		System.out.println(obj);
		System.out.println(p);
	}
}
