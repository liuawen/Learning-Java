package com.atguigu.test03;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 1、把本组学员的姓名，存储到ArrayList集合中，并且指定泛型，
并且要使用foreach和Iterator分别迭代，也要正确指定泛型
 */
public class TestExer1 {
	public static void main(String[] args) {
		//姓名，泛型指定为String
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("杨洪强");
		list.add("苏海波");
		list.add("甄玉禄");
		
		System.out.println("foreach迭代");
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println("Iterator迭代");
		
		//Iterator<E>这个E代表你要迭代的集合的元素类型
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String name = iterator.next();
			System.out.println(name);
		}
	}
}
