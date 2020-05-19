package com.awen.test04;

/*
 * java.lang.Object的方法：
 * （2）public final Class getClass()：返回此 Object 的运行时类。
 */
public class TestMethod2 {
	public static void main(String[] args) {
		Father f = new Son();
		//此时f就有两个类型，编译时类型，Father，运行时类型，Son
		Class c = f.getClass();
		System.out.println(c);
		
		Object obj = 12;//Integer
		System.out.println(obj.getClass());
	}
}
class Father{
	
}
class Son extends Father{
	
}