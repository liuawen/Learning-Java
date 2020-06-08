package com.atguigu.java11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;



public class APITest {
	
	// 集合中的一些增强的API
	@Test
	public void test3() {
		LocalDate localDate = LocalDate.of(2019, 1, 21);
		// 在添加重复元素时, 不是无法添加, 而是抛出异常
		//Set<Integer> set = Set.of(100, 50, 20, 30, 10, 8, 100, 8);
		Set<Integer> set = Set.of(100, 50, 20, 30, 10, 8);
		System.out.println(set.getClass());
		
		Stream<Integer> stream = Stream.of(50, 20, 30, 70);
	}
	
	@Test
	public void test2() {
		int[] arr = {1, 9, 3, 2, 8};
		// 快速把数据变成集合的方法
		List<String> list1 = Arrays.asList("aa", "yyy", "zzz", "123");
		//list1.add("ppp"); // 是一个不可以添加元素的集合
		
		// 集合的创建可以使用更简单的方式
		List<String> list2 = List.of("aa", "bbb", "cc", "DD");
		System.out.println(list2);
		
		//list2.add("yyy"); // 不可以添加元素
		System.out.println(list2);
	}
	
	@Test
	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bbb");
		list.add("cc");
		list.add("DD");
		
		System.out.println(list);
	}
}
