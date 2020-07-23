package com.atguigu.java11;

import java.util.stream.Stream;

import org.junit.Test;

/**
 * 流的处理
 * 1) 创建流
 * 2) 中间操作
 * 3) 终止操作
 */

public class StreamTest {
	
	@Test
	public void test3() {
		// 流的迭代, 创建流
		Stream<Integer> stream1 = Stream.iterate(1, t -> (2 * t) + 1);
		stream1.limit(10).forEach(System.out::println);
		
		System.out.println("*************************");
		// 有限的迭代
		Stream<Integer> stream2 = Stream.iterate(1, t -> t < 1000, t -> (2 * t) + 1);
		stream2.forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		Stream<Integer> stream1 = Stream.of(3, 9, 20, 22, 40, 7);
		// 新方法, takeWhile, dropWhile
		// 从流中一直获取判定器为真的元素, 一旦遇到元素为假, 就终止处理.
		Stream<Integer> stream2 = stream1.takeWhile(t -> t % 2 != 0);
		stream2.forEach(System.out::println);
		
		System.out.println("**********************");
		stream1 = Stream.of(3, 9, 20, 22, 40, 7);
		Stream<Integer> stream3 = stream1.dropWhile(t -> t % 2 != 0);
		stream3.forEach(System.out::println);
		
	}
	
	@Test
	public void test1() {
		Stream<Integer> stream1 = Stream.of(3, 9, 20, 22, 40);
		//stream1.forEach(t -> System.out.println(t));
		stream1.forEach(System.out::println);
		
		System.out.println("***********************************");
		
		Stream<Object> stream2 = Stream.of(); // 流中没有数据
		stream2.forEach(System.out::println);
		
		System.out.println("***********************************");
		
		// 传入null会被解析为是一个数组对象, 会进一步访问它的长度信息
		//Stream<Object> stream3 = Stream.of(null);
		//stream3.forEach(System.out::println);
		
		// 可以传入 一个null来创建流对象
		Stream<Object> stream3 = Stream.ofNullable(null);
		stream3.forEach(System.out::println);
	}
}
