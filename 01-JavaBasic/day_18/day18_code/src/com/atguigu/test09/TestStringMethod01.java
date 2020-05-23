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
		System.out.println(s3);//helloworld
		String s4 = s1.concat(s2);
		System.out.println(s4);//helloworld
		System.out.println(s3 == s4);//false
		System.out.println(s3.equals(s4));//true
	}
	@Test
	public void test2(){
		String str = "    hello   world    ";
		System.out.println(str);//    hello   world
		str = str.trim();
		System.out.println("[" + str + "]");//[hello   world]
		String str2 = "a1 2 3 bc";
		System.out.println(str2);//a1 2 3 bc
		str2 = str2.trim();//如果没有前导和尾部空白，则返回此字符串。
		System.out.println(str2);//a1 2 3 bc
		String str3 = "";
		System.out.println(str3.trim());
		String str4 = new String();
		System.out.println(str4.trim());
		String str5 = new String();
		System.out.println(str5.trim());
	}
	@Test
	public void test1(){
		String str = "hello";
		String str2 = "";
		String str4 = new String();
		String str5 = new String("");
		System.out.println(str.isEmpty());//false
		System.out.println(str.length());//5
		System.out.println(str2.isEmpty());//true
		System.out.println(str2.length());//0
		System.out.println(str4.isEmpty());//true
		System.out.println(str4.length());//0
		System.out.println(str5.isEmpty());//true
		System.out.println(str5.length());//0

		System.out.println(str.length());//5
		System.out.println(str2.length());//

		System.out.println(str.toUpperCase());//HELLO
		System.out.println(str.toUpperCase().toLowerCase());//hello

		String str3 = "WORLD";
		System.out.println(str3.toLowerCase());//world
		System.out.println("AbC".toLowerCase());//abc
	}
}
