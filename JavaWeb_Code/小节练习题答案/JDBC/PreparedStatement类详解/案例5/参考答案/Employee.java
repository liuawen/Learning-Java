package com.itheima.test;

import java.util.Date;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private String post;
	private double salary;
	private Date edate;
	private int deptid;
	public Employee(int id, String name, String gender, String post, double salary, Date edate, int deptid) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.post = post;
		this.salary = salary;
		this.edate = edate;
		this.deptid = deptid;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", post=" + post + ", salary=" + salary
				+ ", edate=" + edate + ", deptid=" + deptid + "]";
	}
	
}
