package com.atguigu.java3;

public class Student extends Person{
	
	String major;
	int id = 1002;//学号
	
	public Student(){
		super();
	}
	public Student(String major){
		super();
		this.major = major;
	}
	
	public Student(String name,int age,String major){
//		this.name = name;
//		this.age = age;
		super(name,age);
		this.major = major;
	}
	
	@Override
	public void eat() {
		System.out.println("学生：多吃有营养的食物");
	}
	
	public void study(){
		System.out.println("学生：学习知识");
		this.eat();
		super.eat();
		walk();
	}
	
	public void show(){
		System.out.println("name = " + name + ", age = " + age);
		System.out.println("id = " + this.id);
		System.out.println("id = " + super.id);
	}
}
