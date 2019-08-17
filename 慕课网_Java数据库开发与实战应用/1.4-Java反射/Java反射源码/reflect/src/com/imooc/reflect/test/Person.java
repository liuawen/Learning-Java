package com.imooc.reflect.test;

public class Person {
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	private String name;
	private String sex;
/*	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}*/
	
	
	public void eat(){
		System.out.println("吃....");
	}
	
	private void run(){
		System.out.println("跑.....");
	}
	
	public String sayHello(String name){
		return "Hello "+name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}
	
}
