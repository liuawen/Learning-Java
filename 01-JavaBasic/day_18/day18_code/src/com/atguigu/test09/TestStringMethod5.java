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
		System.out.println(index);//10
	}
	@Test
	public void test04(){
		String str = "123.45";
//		String str = "123";
		int index = str.indexOf(".");
		System.out.println(index);//3
		int index2 = str.indexOf(".",3);
		System.out.println(index2);//3
		int index3 = str.indexOf(".",4);
		System.out.println(index3);//-1
		int index4 = str.indexOf(1,0);
		System.out.println(index4);//-1
		int index5 = str.indexOf('1',0);
		System.out.println(index5);//0
	}
	@Test
	public void test02(){
		String str = "123.45";
//		String str = "123";
		int index = str.indexOf(".");
		System.out.println(index);//3
		int index2 = str.indexOf("12");//0
		System.out.println(index2);
		int index3 = str.indexOf("54");
		System.out.println(index3);//-1
		int index4 = str.indexOf("A");
		System.out.println(index4);//-1
		int index5 = str.indexOf(0);
		System.out.println(index5);//-1
		int index6 = str.indexOf('1');
		System.out.println(index6);//0
		int index7 = str.indexOf('5');
		System.out.println(index7);//5

	}
	
	@Test
	public void test01(){
		String str = "123.45";
		
		if(str.contains(".")){
			System.out.println("是小数");
		}
		System.out.println(str.contains(""));//true
		System.out.println(str.contains("12345"));//false
		System.out.println(str.contains("123"));//true
		System.out.println(str.contains("54"));//false
//		System.out.println(str.contains(null));//java.lang.NullPointerException
	}
}
