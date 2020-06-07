package cn.mldn.mldnboot.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private String mid ;		// 用户编号
	private String name ;		// 用户姓名
	private Integer age ;		// 用户年龄
	private Double salary ;		// 基本工资
	private Date birthday ;		// 用户生日
	// setter、getter略
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
