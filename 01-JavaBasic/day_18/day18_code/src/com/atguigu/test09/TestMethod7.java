package com.atguigu.test09;

import org.junit.Test;

/*
 * 方法系列（7）：匹配规则
 * boolean matches(正则表达式)
 * 
 * 正则表达式：用于检测文本的格式
 * 校验某个字符串是否符合xx规则
 * 例如：电话号码
 * 		甚至可以校验是否是移动号...
 * 		银行卡号
 * 	  	邮箱格式
 * 		....
 * 
 * 
 */
public class TestMethod7 {
	@Test
	public void test2(){
		String str = "12a345";
		//简单判断是否全部是数字，这个数字可以是1~n位
		
		//正则不是Java的语法，它是独立与Java的规则
		//在正则中\是表示转义，
		//同时在Java中\也是转义
		boolean flag = str.matches("\\d+");
		System.out.println(flag);
	}
	
	@Test
	public void test1(){
		String str = "123456789";
		
		//判断它是否全部由数字组成，并且第1位不能是0，长度为9位
		//第一位不能是0，那么数字[1-9]
		//接下来8位的数字，那么[0-9]{8}+
		boolean flag = str.matches("[1-9][0-9]{8}+");
		System.out.println(flag);
	}
}
