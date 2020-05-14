package com.atguigu.newinterface;

public interface CompareA {
	
	//jdk 7及以前，只能在接口中定义常量和抽象方法
	
	//jdk 8 可以额外定义静态方法和默认方法 (静态方法和默认都有方法体)
	//静态方法
	public static void method1(){
		System.out.println("CompareA:北京");
	}
	
	//默认方法
	public default void method2(){
		System.out.println("CompareA:上海");
	}
	
	default void method3(){
		System.out.println("CompareA:深圳");
	}
	
}
