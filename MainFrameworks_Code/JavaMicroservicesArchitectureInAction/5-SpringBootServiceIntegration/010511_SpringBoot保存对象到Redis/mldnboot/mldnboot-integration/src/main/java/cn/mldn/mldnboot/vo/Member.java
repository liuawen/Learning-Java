package cn.mldn.mldnboot.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private String mid;
	private String name ;
	private Integer age;
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
}
