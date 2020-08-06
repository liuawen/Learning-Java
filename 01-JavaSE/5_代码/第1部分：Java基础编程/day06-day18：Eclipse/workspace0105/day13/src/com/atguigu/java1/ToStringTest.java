package com.atguigu.java1;

import java.util.Date;

/*
 * Object类中toString()的使用：
 * 
 * 1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 * 
 * 2. Object类中toString()的定义：
 *   public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }
 * 
 * 3. 像String、Date、File、包装类等都重写了Object类中的toString()方法。
 *    使得在调用对象的toString()时，返回"实体内容"信息
 *    
 * 4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
 */
public class ToStringTest {
	public static void main(String[] args) {
		
		Customer cust1 = new Customer("Tom",21);
		System.out.println(cust1.toString());//com.atguigu.java1.Customer@15db9742-->Customer[name = Tom,age = 21]
		System.out.println(cust1);//com.atguigu.java1.Customer@15db9742-->Customer[name = Tom,age = 21]
		
		String str = new String("MM");
		System.out.println(str);//MM
		
		Date date = new Date(4534534534543L);
		System.out.println(date.toString());//Mon Sep 11 08:55:34 GMT+08:00 2113
		
	}
}
