package com.atguigu.mybatis.entities;

public class Employee {

	private Integer id;
	private String lastName;
	private String email;
	private double salary;
	private Integer deptId;

	public Employee(Integer id, String lastName, String email, double salary, Integer deptId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.deptId = deptId;
	}

	public Employee() {
		super();
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", salary=" + salary + ", deptId="
				+ deptId + "]";
	}

}
