package com.itheima.core.dao;
import org.apache.ibatis.annotations.Param;
import com.itheima.core.po.User;
/**
 * 用户DAO层接口
 */
public interface UserDao {
	/**
	 * 通过账号和密码查询用户
	 */
	public User findUser(@Param("usercode") String usercode,
			                @Param("password") String password);
}
