package com.atguigu.test02;

import java.util.ArrayList;

import org.junit.Test;

/*
 * 泛型的好处：
 * （1）安全
 * （2）避免类型转换
 */
public class TestGood {
	@Test
	public void test1(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
//		list.add(1);//编译报错，因为我告诉ArrayList，我的元素类型是String，所以Integer对象进不去
		
		//此时不需要用Object处理了，因为它知道里面的元素是String
		for (String name : list) {
			System.out.println("名字的字数：" +name.length());
		}
	}
}
