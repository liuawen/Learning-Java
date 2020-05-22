package com.atguigu.test09;

import org.junit.Test;

/*
 * 方法系列一：
 * （1）int length()：返回字符串的长度，返回的是字符的个数
 * 因为String的内部（JDK1.9之前）用char[]实现，这个长度就是value数组的长度
 * （2）boolean isEmpty()：是否是空字符串
 * （3）String toLowerCase()
 *    String toUpperCase()
 * （4）String trim() ：去掉字符串的前后空白符 
 * （5）String concat()：拼接，等价于+
 */
public class TestStringMethod01 {
	
	@Test
	public void test3(){
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1 + s2;
		String s4 = s1.concat(s2);
		
		System.out.println(s3 == s4);//false
		System.out.println(s3.equals(s4));//true
	}
	@Test
	public void test2(){
		String str = "    hello   world    ";
		str = str.trim();
		System.out.println("[" + str + "]");
	}
	@Test
	public void test1(){
		String str = "hello";
		System.out.println(str.toUpperCase());
	}
}
