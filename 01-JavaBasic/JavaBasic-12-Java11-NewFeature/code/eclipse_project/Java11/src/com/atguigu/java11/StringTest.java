package com.atguigu.java11;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.junit.Test;

public class StringTest {
	
	@Test
	public void testName3() throws Exception {
		FileInputStream fis = new FileInputStream("src/com/atguigu/java11/StringTest.java");
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		String string = new String(buffer);
		string.lines().forEach(System.out::println);
	}
	
	@Test
	public void testName2() throws Exception {
		String string = "Java";
		String string2 = string.repeat(5);
		System.out.println(string2);
	}

	@Test
	public void testName() throws Exception {
		String string = " \t  \r\n ";
		System.out.println(string.isBlank()); // 判断字符串中的字符是否都是空白
		
		System.out.println("**************************");
		
		string = " \t  \r\n abc \t　";
		String string2 = string.strip(); // 去重字符串首尾的空白, 包括英文和其他所有语言中的空白字符
		System.out.println(string2);
		System.out.println(string2.length());
		
		String string3 = string.trim(); // 去重字符串首尾的空白字符, 只能去除码值小于等于32的空白字符
		System.out.println(string3);
		System.out.println(string3.length());
		
		System.out.println("**************************");
		String string4 = string.stripLeading(); // 去重字符串首部的空白
		System.out.println(string4);
		System.out.println(string4.length());
		
		String string5 = string.stripTrailing(); // 去重字符串尾部的空白
		System.out.println(string5);
		System.out.println(string5.length());
	}
}	
