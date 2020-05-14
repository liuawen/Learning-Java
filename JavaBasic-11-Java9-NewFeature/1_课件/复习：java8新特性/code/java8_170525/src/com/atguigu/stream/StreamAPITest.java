package com.atguigu.stream;

import org.junit.Test;

import com.atguigu.lambda.Employee;
import com.atguigu.lambda.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1.Stream API: java提供一套api（java.util.stream），使用这套api可以实现
 * 对数组、集合数据的过滤、归约、合并等操作。
 *
 * 2.注意点： 
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。 
 * ③Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 * 3.Stream的使用流程： 
 * 步骤一：Stream的实例化 
 * 步骤二：一系列的中间操作 
 * 步骤三：终止操作
 *
 * 注意：
 * ①步骤二中的中间操作可以有多个 
 * ②如果没有终止操作，那么一系列的中间操作是不会执行的。只有执行了步骤三的终止操作，步骤二才会执行：惰性求值
 * ③终止操作一旦执行，就不可以再执行中间操作或其他的终止操作。
 *
 *
 * 测试Stream的实例化
 *
 *
 * Created by shkstart on 2017/8/29 0029.
 */
public class StreamAPITest {
	// 方式一：通过集合
	@Test
	public void test1() {
		// default Stream<E> stream() : 返回一个顺序流
		List<Employee> list = EmployeeData.getEmployees();
		Stream<Employee> stream = list.stream();

		// default Stream<E> parallelStream() : 返回一个并行流
		Stream<Employee> stream1 = list.parallelStream();

	}

	// 方式二：通过数组
	@Test
	public void test2() {
		// 调用Arrays的static <T> Stream<T> stream(T[] array): 返回一个流
		String[] arr = new String[] { "MM", "GG", "JJ", "DD" };
		Stream<String> stream = Arrays.stream(arr);

	}

	// 方式三：Stream的静态方法of()
	@Test
	public void test3() {
		// public static<T> Stream<T> of(T... values) : 返回一个流
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
	}

	// 方式四：创建无限流
	@Test
	public void test4() {
		// 迭代
		// public static<T> Stream<T> iterate(final T seed, final
		// UnaryOperator<T> f)
		Stream<Integer> stream = Stream.iterate(0, x -> x + 2);
		stream.limit(10).forEach(System.out::println);

		// 生成
		// public static<T> Stream<T> generate(Supplier<T> s)
		Stream<Double> stream1 = Stream.generate(Math::random);
		stream1.limit(10).forEach(System.out::println);

	}

}
