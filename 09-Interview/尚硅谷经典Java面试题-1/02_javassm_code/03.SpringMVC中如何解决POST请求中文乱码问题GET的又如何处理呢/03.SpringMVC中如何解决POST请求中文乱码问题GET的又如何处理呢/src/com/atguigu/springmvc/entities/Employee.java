package com.atguigu.springmvc.entities;

public class Employee {

	private Integer id;
	private String lastName;
	private String email;
	private Department dept;

	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, String email, Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", dept=" + dept + "]";
	}

}
