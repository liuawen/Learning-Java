package com.itheima.po;
/**
 * 用户POJO类
 */
public class User {
	private Integer id;        //id
	private String username;  //用户名
	private String password;  //密码
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
