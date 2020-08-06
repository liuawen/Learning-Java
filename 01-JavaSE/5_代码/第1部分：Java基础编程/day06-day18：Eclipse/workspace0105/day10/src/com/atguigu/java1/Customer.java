package com.atguigu.java1;
/*
 * JavaBean是一种Java语言写成的可重用组件。

	所谓JavaBean，是指符合如下标准的Java类：
		>类是公共的
		>有一个无参的公共的构造器
		>有属性，且有对应的get、set方法

 * 
 */
public class Customer {
	
	private int id;
	private String name;
	
	public Customer(){
		
	}
	
	public void setId(int i){
		id = i;
	}
	public int getId(){
		return id;
	}
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	
}
