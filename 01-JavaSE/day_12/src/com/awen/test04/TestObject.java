package com.awen.test04;

/*
 * Java中规定：
 * 如果一个类没有显式声明它的父类（即没有写extends xx），那么默认这个类的父类就是java.lang.Object。
 * 
 * 类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。
 *
 * 如何理解根父类？
 * （1）所有对象（包括数组）都实现这个类的方法。
 * 换句话说Object类中声明的方法，所有引用数据类型（包括数组）中都有
 * （2）所有类的对象的实例化过程，都会调用Object的实例初始化方法
 * （3）所有的对象都可以赋值给Object的变量
 * 或者说Object类型的变量，形参，数组可以接收任意类型的对象。
 * 
 * 
 */
public class TestObject {
	
	public TestObject() {
		super();//调用Object的无参构造，或者说是无参的实例初始化方法<init>()
	}

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		TestObject t = new TestObject();
		
		Object obj = new TestObject();///多态引用
		
		test("hello");//多态参数
		
		Object[] all = new Object[5];//多态数组
		all[0] = new TestObject();///多态引用
		
		Object[] array1 = new TestObject[5];//可以
//		Object[] array2 = new int[5];//不可以，int是基本数据类型
	}
	public static void test(Object obj){
		
	}
}
