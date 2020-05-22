package com.atguigu.test08;

import org.junit.Test;

import javax.swing.*;

/*
 * java.lang.String：
 * 1、特点
 * （1）String类型不能被继承，因为String是由final修饰
 * （2）String类型的对象是不可变
 * 换句话说，只要修改字符串，就会产生新对象
 * （3）String对象不可变的特性，使得我们可以把一些字符串存到常量池中，
 * 字符串有常量池。常量池中的是可以共享的。
 * 
 * 字符串常量池在哪里？Oracle官方虚拟机HotSpot
 * （1）JDK1.6以及之前：方法区
 * （2）JDK1.7：挪到堆中，即在堆中单独划分了一块来存字符串常量
 * （3）JDK1.8：从堆中挪出，挪到一个“元空间meta space”，即类似于方法区
 * 
 * （4）String对象底层的存储
 * JDK1.9之前：底层是用char[]存储
 * JDK1.9之后：底层选用byte[]存储
 * 
 * （5）String对象怎么就不可变
 * ①底层char[]数组有final修饰，意味着这个数组不能扩容等，来达到存更多的字符
 * ②char[]数组是私有的，我们程序员无法直接操作这个char[]数组，而且String没有提供这样的方法，来修改char[]数组的元素的值。
 * String提供的所有的方法，对字符串的修改都是给你返回一个新的字符串对象。
 */
public class TestString01 {
	@Test
	public void test02(){
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);//true

		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3 == s4 );//false

	}
	
	@Test
	public void test01(){
		String s1 = "hello";
		System.out.println(s1);//hello
		s1 = "world";
		System.out.println(s1);//world
		s1 = s1 + "java";
		System.out.println(s1);//worldjava

		String s  = "";
		System.out.println(s);//
		change(s);
		System.out.println(s);//
	}
	
	public void change(String str){
		str = "hello";
	}
}
