package com.atguigu.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1.方法引用可以看做是Lambda表达式深层次的表达，或者可以理解为：方法引用就是Lambda表达式。
 *   又因为Lambda表达式本身就是函数式接口的实例，进而方法引用也可以看做函数式接口的实例。
 *
 * 2.使用情境：
 * 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 3.要求：函数式接口中抽象方法的形参列表和返回值类型 要与 方法引用对应的方法的形参列表和返回值类型一致！
 *
 * 4.格式：类(或 对象) :: 方法名
 *
 * 5.分为如下的三种情况：
 *   ① 对象 :: 实例方法
 *   ② 类 :: 静态方法
 *   
 *   ③ 类 :: 实例方法  （有难度）
 *
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	// void accept(T t)
	//PrintStream类中 void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("beijing");

		System.out.println("***************");
		
		PrintStream ps = System.out;
		Consumer<String> con2 = ps :: println;
		con2.accept("beijing");

	}

	//T get()
	//String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001, "Tom", 23, 4534);
		Supplier<String> sup = () -> emp.getName();
		String name = sup.get();
		System.out.println(name);

		System.out.println("***************");

		Supplier<String> sup1 = emp :: getName;
		name = sup1.get();
		System.out.println(name);
	}

	// 情况二：类 :: 静态方法
	//R compare(T t1,T2)
	// Integer中的静态方法：R compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com = (num1, num2) -> Integer.compare(num1, num2);
		int value = com.compare(12, 32);
		System.out.println(value);

		System.out.println("***************");
		
		Comparator<Integer> com1 = Integer :: compare;
		int value1 = com1.compare(12, 32);
		System.out.println(value1);
	}
	
	//R apply(T t)
	//Math类的静态方法：long  round(double d)
	@Test
	public void test4() {
		Function<Double, Long> func1 = d -> Math.round(d);
		Long value = func1.apply(12.3);
		System.out.println(value);

		System.out.println("***************");
		
		Function<Double, Long> func2 = Math::round;
		value = func2.apply(12.3);
		System.out.println(value);
	}

	// 情况三：类 :: 实例方法 （有难度）
	// R compare(T t1, T t2)
	// t1.非静态方法(t2)
	@Test
	public void test5() {
		Comparator<String> com = (s1, s2) -> s1.compareTo(s2);
		int value = com.compare("abad", "abdd");
		System.out.println(value);

		System.out.println("***************");

		Comparator<String> com1 = String :: compareTo;
		value = com1.compare("abad", "abdd");
		System.out.println(value);
	}
	
	//boolean test(T t1, T t2)
	//t1.非静态方法(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> bi = (s1, s2) -> s1.equals(s2);
		boolean b = bi.test("abc", "abc");
		System.out.println(b);

		System.out.println("***************");
		
		BiPredicate<String, String> bi1 = String :: equals;
		b = bi1.test("abc", "abc");
		System.out.println(b);
	}

	//R apply(T t)
	//t.非静态方法()
	@Test
	public void test7() {
		Employee emp = new Employee(1001, "Jerry", 32, 23430);
		Function<Employee, String> func1 = (e) -> e.getName();
		String name = func1.apply(emp);
		System.out.println(name);

		System.out.println("***************");

		Function<Employee, String> func2 = Employee::getName;
		name = func2.apply(emp);
		System.out.println(name);
	}

}
