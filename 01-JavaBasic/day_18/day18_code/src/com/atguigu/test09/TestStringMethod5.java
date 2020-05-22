package com.atguigu.test09;

import org.junit.Test;

/*
 * 方法系列（5）：和查找有关
 * （1）是否包含
 * boolean contanis
 * （2）int indexOf(xx)：如果存在返回下标，如果不存在返回-1
 * （3）int lastIndexOf(xx)：如果存在返回最后一个的下标，如果不存在返回-1
 */
public class TestStringMethod5 {
	@Test
	public void test03(){
		String fileName = "Hello.java.txt";
		//文件的后缀名是什么
		//截取文件的后缀名
		//(1)第一步，找到最后一个.的位置
		int index = fileName.lastIndexOf(".");
		System.out.println(index);
	}
	
	@Test
	public void test02(){
		String str = "123.45";
//		String str = "123";
		int index = str.indexOf(".");
		System.out.println(index);
	}
	
	@Test
	public void test01(){
		String str = "123.45";
		
		if(str.contains(".")){
			System.out.println("是小数");
		}
	}
}
