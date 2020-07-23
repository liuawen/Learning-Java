package com.atguigu.lambda;

import java.util.Comparator;

import org.junit.Test;

public class LambdaTest {
	
	
	//举例2：
	@Test
	public void test2(){
		Comparator<Integer> com1 = new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		
		int value = com1.compare(12, 21);
		System.out.println(value);
		System.out.println("*******************");
		
		Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1, o2);
		value = com2.compare(12, 21);
		System.out.println(value);
		System.out.println("*******************");
		
		Comparator<Integer> com3 = Integer::compare;//方法引用
		value = com3.compare(12, 21);
		System.out.println(value);

		
	}
	
	//举例1：
	@Test
	public void test1(){
		//提供了一个实现Runnable接口匿名实现类的对象
		Runnable run1 = new Runnable(){

			@Override
			public void run() {
				System.out.println("马上就双11光棍节了...");
			}
			
		};
		
		run1.run();
		
		System.out.println("*******************");
		//使用Lambda表达式来充当此对象：run2
		Runnable run2 = () -> System.out.println("你们有没有因为爱情而鼓掌呢？");
		run2.run();
	}
}
