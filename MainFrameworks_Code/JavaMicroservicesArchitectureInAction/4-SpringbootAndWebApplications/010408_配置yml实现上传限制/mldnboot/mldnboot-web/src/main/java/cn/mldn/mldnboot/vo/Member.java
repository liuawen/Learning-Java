package cn.mldn.mldnboot.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@SuppressWarnings("serial")
public class Member implements Serializable {
	@NotNull(message="{member.mid.notnull.error}")
	@Email(message="{member.mid.email.error}")
	private String mid ;		// 用户编号，使用email作为用户名
	@NotNull(message="{member.age.notnull.error}")
	@Digits(integer=3,fraction=0,message="{member.age.digits.error}")
	private Integer age ;		// 用户年龄
	@NotNull(message="{member.salary.notnull.error}")
	@Digits(integer=20,fraction=2,message="{member.salary.digits.error}")
	private Double salary ;		// 基本工资
	@NotNull(message="{member.birthday.notnull.error}")
	private Date birthday ;		// 用户生日
	// setter、getter略
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
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
