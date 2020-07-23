package com.atguigu.test02;

import java.util.Arrays;

import org.junit.Test;

/*
 * 数据结构：
 * 	 逻辑结构：针对程序员使用角度来说
 * 	物理结构：针对程序员如何实现这个逻辑结构的底层的结构
 * 
 * 1、动态数组
 * 物理结构：数组
 * 逻辑结构：动态数组
 * 	 对于使用者来说，可以自动扩容，自动记录有效元素的个数.....
 */
public class TestMyArrayList {
	@Test
	public void test1(){
		//1、创建了一个容器对象，比喻，准备了一个箱子
		MyArrayList list = new MyArrayList();
		
		//2、往容器中装对象
		//伪代码
		list.add(new Apple());
		list.add("hello");
		for (int i = 1; i <= 5; i++) {
			list.add(i);
		}
		System.out.println("元素的个数：" + list.size());
		System.out.println("实际的容量：" + list.capacity());
	
		//获取[5]的元素
		Object obj = list.get(5);
		System.out.println(obj);
		
		//替换[5]位置的元素
		list.set(5, "张三");
		obj = list.get(5);
		System.out.println(obj);
		
		
		list.insert(0, "aa");
		list.insert(0, "bb");
		list.insert(0, "cc");
		list.insert(0, "dd");
		System.out.println("元素的个数：" + list.size());
		System.out.println("实际的容量：" + list.capacity());
		
		Object[] all = list.getAll();
		System.out.println(Arrays.toString(all));
		
		System.out.println("删除后：");
		list.remove(2);
		all = list.getAll();
		System.out.println(Arrays.toString(all));
	
		list.add(null);//null也可以作为有效元素
		int index = list.indexOf(null);
		System.out.println(null+"在我们的容器的位置：" + index);
	}
}
class Apple{
	
}
