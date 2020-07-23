package com.atguigu.bean;

public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/*
ID     	姓名      年龄    		工资     	 职位      状态      奖金     		 股票    	领用设备
 1      段誉      22        3000.0
 2      令狐冲  32        18000.0  架构师  FREE  15000.0  2000    联想T4(6000.0)
 3      任我行  23        7000.0   程序员  FREE                   戴尔(NEC17寸)
 4      张三丰  24        7300.0   程序员  FREE                   戴尔(三星 17寸)
 5      周芷若  28        10000.0  设计师  FREE  5000.0           佳能 2900(激光)
	 */
	@Override
	public String toString() {
		return getBasicInfo();
	}
	protected String getBasicInfo() {
		return id + "\t" + name + "\t" + age + "\t" + salary;
	}
	
}
