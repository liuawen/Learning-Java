package com.atguigu.exer;

public class Person {
	
	String name;
	int age;
	/**
	 * sex:1 表明是男性
	 * sex:0 表明是女性
	 */
	int sex;
	
	public void study(){
		System.out.println("studying");
	}
	
	public void showAge(){
		System.out.println("age:" + age);
	}
	
	public int addAge(int i){
		age += i;
		return age;
	}
}
