package com.itheima.instance.factory;
public class MyBean3Factory {
	public MyBean3Factory() {
		System.out.println("bean3工厂实例化中");
	}
    //创建Bean3实例的方法
	public Bean3 createBean(){
		return new Bean3();
	}
}
