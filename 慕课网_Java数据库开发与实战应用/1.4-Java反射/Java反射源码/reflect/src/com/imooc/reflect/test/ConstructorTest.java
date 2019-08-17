package com.imooc.reflect.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class ConstructorTest {

	@Test
	/**
	 * 获得无参数的构造方法
	 */
	public void demo1() throws Exception{
		// 获得类的字节码文件对应的对象:
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		Constructor c = class1.getConstructor();
		Person person = (Person) c.newInstance();// 相当于Person person = new Person();
		// person.eat();
	}
	
	@Test
	/**
	 * 获得有参数的构造方法
	 */
	public void demo2() throws Exception{
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		Constructor c = class1.getConstructor(String.class,String.class);
		Person person = (Person) c.newInstance("张三","男");// Person person = new Person("张三","男");
		System.out.println(person);
	}
}
