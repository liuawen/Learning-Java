package com.atguigu.java1;

public class Student extends Person{

	String major;
	
	public Student(){
		
	}
	public Student(String major){
		this.major = major;
	}
	
	public void study(){
		System.out.println("学习。专业是：" + major);
	}
	
	//对父类中的eat()进行了重写
	public void eat(){
		System.out.println("学生应该多吃有营养的食物");
	}
	
	public void show(){
		System.out.println("我是一个学生");
	}
	
	public String info(){
		return null;
	}
	
//	public int info1(){
//		return 1;
//	}
	
//	public void walk(int distance){
//		System.out.println("重写的方法");
//	}
	
	
	public void walk(int distance) {
		System.out.println("重写的方法");
	}

}