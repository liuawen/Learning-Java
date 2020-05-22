package com.atguigu.test09;

import java.util.Scanner;

import org.junit.Test;

/*
 * 方法系列二：和char相关
 * （1）char[] toCharArray()
 * （2）char charAt(index)
 * （3）String(char[] arr)
 * （4）String(char[] arr,int offset, int count)
 */
public class TestStringMethod2 {
	@Test
	public void test05(){
		char[] arr = {'h','e','l','l','o'};
		
		String string = new String(arr,2,3);//从[2]开始，取3个
		System.out.println(string);
	}
	
	@Test
	public void test04(){
		char[] arr = {'h','e','l','l','o'};
		
		String string = new String(arr);
		System.out.println(string);
	}
	
	@Test
	public void test03(){
		String str = "HelloWorld";
		System.out.println(str.charAt(4));
	}
	@Test
	public void test02(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入性别：");
		String str = input.next();
		char gender = str.charAt(0);
		System.out.println(gender);
	}
	
	@Test
	public void test01(){
		String str = "HelloWorld";
		
		//统计大写字母的个数
		char[] arr = str.toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>='A' && arr[i]<='Z'){
				count++;
			}
		}
		System.out.println("大写字母的个数：" +count);
	}
}
