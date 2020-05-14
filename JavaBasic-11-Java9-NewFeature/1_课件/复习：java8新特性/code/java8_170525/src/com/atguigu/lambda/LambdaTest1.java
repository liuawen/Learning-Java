package com.atguigu.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/*
 * 一、Lambda语法
 * 
 * 1.举例：(o1,o2) -> Integer.compare(o1, o2);
 * 
 *  -> : 称为lambda操作符或箭头操作符
 *  ->左边： lambda参数列表
 *  ->右边：lambda体
 * 
 * 2.分6种说明如何使用
 * 
 * 二、函数式接口
 * 1.只包含一个抽象方法的接口，称为函数式接口
 * 2.lambda表达式的使用，依赖于函数式接口
 * 3.只有需要实例化函数式接口时，我们才可以使用lambda表达式 ---lambda表达式使用场景
 * 4.在接口声明上，可以添加@FunctionalInterface，检验一个接口是否是函数式接口
 * 
 * 
 */
public class LambdaTest1 {
	
	//语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
	@Test
	public void test7(){
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
		int value1 = com2.compare(12, 21);
		System.out.println(value1);
		
	}
	
	//语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
	@Test
	public void test6(){
		Comparator<Integer> com1 = new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println(o1);
				System.out.println(o2);
				return Integer.compare(o1, o2);
			}
		};
		
		int value = com1.compare(12, 21);
		System.out.println(value);
		
		System.out.println("*******************");
		
		Comparator<Integer> com2 = (o1,o2) -> {
			System.out.println(o1);
			System.out.println(o2);
			return Integer.compare(o1, o2);
		};
		int value1 = com1.compare(12, 21);
		System.out.println(value1);
	}
	
	//语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
	@Test
	public void test5(){
		
		Consumer<String> com3 = (t) ->{
			System.out.println(t);
		};
		com3.accept("我爱北京故宫");
		
		System.out.println("*******************");
		
		Consumer<String> com4 = t ->{
			System.out.println(t);
		};
		com4.accept("我爱北京故宫");
	}
	
	@Test
	public void test4(){
		int[] arr = new int[]{1,2,3};
		
		int[] arr1 = {1,2,3};//“类型推断”
		
		ArrayList<String> list = new ArrayList<String>();
		
		ArrayList<String> list1 = new ArrayList<>();//“类型推断”
	}
		
	//语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
	@Test
	public void test3(){
		Consumer<String> com2 = (String t) ->{
			System.out.println(t);
		};
		com2.accept("我爱北京天安门");
		
		System.out.println("*******************");
		
		Consumer<String> com3 = (t) ->{
			System.out.println(t);
		};
		com3.accept("我爱北京故宫");
	}
	
	//语法格式二：Lambda 需要一个参数，但是没有返回值。
	@Test
	public void test2(){
		Consumer<String> com1 = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		};
		
		com1.accept("我爱你，中国");
		System.out.println("*******************");
		Consumer<String> com2 = (String t) ->{
			System.out.println(t);
		};
		com2.accept("我爱北京天安门");
		
	}
	
	//语法格式一：无参，无返回值
	@Test
	public void test1(){
		Runnable run1 = new Runnable(){

			@Override
			public void run() {
				System.out.println("马上就双11光棍节了...");
				System.out.println("马上就双11光棍节了...");
			}
			
		};
		
		run1.run();
		
		System.out.println("*******************");
		//使用Lambda表达式来充当此对象：run2
		Runnable run2 = () -> {
			System.out.println("你们有没有因为爱情而鼓掌呢？");
			System.out.println("你们有没有因为爱情而鼓掌呢？");
			System.out.println("你们有没有因为爱情而鼓掌呢？");
		};
		run2.run();
	}
}
