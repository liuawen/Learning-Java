package com.itheima.vo;
import java.util.List;
import com.itheima.po.User;
/**
 * 用户包装类
 */
public class UserVO {
	private List<User> users;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
