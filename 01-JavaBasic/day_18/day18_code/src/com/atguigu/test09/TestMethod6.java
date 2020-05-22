package com.atguigu.test09;

import org.junit.Test;

/*
 * 方法系列（6）：截取
 * (1)String substring(int beginIndex)：从字符串的[beginIndex]截取到最后
 * (2)String substring(int beginIndex, int endIndex)：截取字符串的[beginIndex,endIndex)部分
 */
public class TestMethod6 {
	@Test
	public void test04(){
		String str = "helloworldjava";
		String sub = str.substring(2, 6);
		System.out.println(sub);
	}
	
	@Test
	public void test03(){
		String fileName = "Hello.java.txt";
		//文件的后缀名是什么
		//截取文件的后缀名
		//(1)第一步，找到最后一个.的位置
		int index = fileName.lastIndexOf(".");

		//(2)截取
		String sub = fileName.substring(index);
		System.out.println(sub);
	}
}
