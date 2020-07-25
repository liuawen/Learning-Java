package com.itheima.po;
/**
 * 用户POJO类
 */
public class User {
	private Integer id;       //用户id
	private String username; //用户
	private Integer password;//用户密码
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
} 
