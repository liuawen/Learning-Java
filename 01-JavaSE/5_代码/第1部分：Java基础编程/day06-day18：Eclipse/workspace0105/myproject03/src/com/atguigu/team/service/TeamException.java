package com.atguigu.team.service;
/**
 * 
 * @Description 自定义异常类
 * @author shkstart  Email:shkstart@126.com
 * @version 
 * @date 2019年2月12日上午10:51:19
 *
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -3387514229948L;
	
	public TeamException(){
		super();
	}
	
	public TeamException(String msg){
		super(msg);
	}
}
