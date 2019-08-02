package com.atguigu.p2;

public class Customer {
	private String name;
	private char gender;
	private int age;
	private String phone;
	private String email;

	public Customer(String name, char gender, int age) {
		this(name, gender, age, "", "");
	}

	public Customer(String name, char gender, int age, String phone,
			String email) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetails() {
		return name + "\t" + gender + "\t" + age + "\t\t" + phone + "\t" + email;
	}
}
