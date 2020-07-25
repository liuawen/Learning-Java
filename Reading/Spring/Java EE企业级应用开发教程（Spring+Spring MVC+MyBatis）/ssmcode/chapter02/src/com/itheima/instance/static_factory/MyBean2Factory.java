package com.itheima.instance.static_factory;
public class MyBean2Factory {	
	//使用自己的工厂创建Bean2实例
	public static Bean2 createBean(){
		return new Bean2();
	}
}
