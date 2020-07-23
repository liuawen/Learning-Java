package com.atguigu.test09;

import org.junit.Test;

/*
 * 方法系列（4）：
 * （1）boolean startsWith(xx)
 * （2）boolean endsWith(xx)
 */
public class TestStringMethod4 {
	@Test
	public void test3(){
		String fileName = "Hello.class";
		if(fileName.endsWith(".java")){
			System.out.println("Java的源文件");
		}else if(fileName.endsWith(".class")){
			System.out.println("字节码文件");
		}
		//字节码文件
		System.out.println(fileName.endsWith(""));//true
		System.out.println(fileName.endsWith("Hello.class"));//true
	}
	
	@Test
	public void test2(){
		String str = "尚硅谷是一家靠谱的培训机构";
		System.out.println(str.startsWith("尚硅谷"));
	}
	
	@Test
	public void test1(){
		String name = "菜鸡文";
		if(name.startsWith("菜")){
			System.out.println("菜鸡文是菜家的人");
		}else{
			System.out.println("菜鸡文不是菜家人");
		}
		//菜鸡文是菜家的人
		System.out.println(name.startsWith(""));//true
		System.out.println(name.startsWith("菜鸡文"));//true
	}
}
