package com.atguigu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.atguigu.lambda.Employee;
import com.atguigu.lambda.EmployeeData;

/**
 * 步骤三：终止操作
 *
 * Created by shkstart on 2017/8/29 0029.
 */
public class StreamAPITest2 {

	// 3-收集:将集合--->Stream --->集合
	@Test
	public void test5() {
		// collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，
		// 用于给Stream中元素做汇总的方法

		List<Employee> list = EmployeeData.getEmployees();
		List<Employee> list1 = list.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toList());
		// 遍历
		list1.forEach(System.out::println);

		System.out.println();

		Set<Employee> set = list.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toSet());
		set.forEach(System.out::println);

		System.out.println();

		ArrayList<Employee> list2 = list.stream().filter(e -> e.getSalary() > 5000)
				.collect(Collectors.toCollection(ArrayList::new));
		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}

	// 2-归约
	@Test
	public void test4() {
		// reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		// Integer sum = list.stream().reduce(0, (x1, x2) -> x1 + x2);
		Integer sum = list.stream().reduce(10, Integer::sum);
		System.out.println(sum);

		// reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
		// 练习1：计算公司所有员工工资的总和
		List<Employee> emps = EmployeeData.getEmployees();
		Stream<Double> moneyStream = emps.stream().map(Employee::getSalary);
		Optional<Double> moneyOptional = moneyStream.reduce(Double::sum);
		System.out.println(moneyOptional.get());

		// 练习2：员工姓名中包含“马”字的个数
		Stream<String> nameStream = emps.stream().map(Employee::getName);
		Stream<Character> charStream = nameStream.flatMap(StreamAPITest1::fromStringToChar);
		// 方式一：
		// long count = charStream.filter(c -> c.equals('马')).count();
		// System.out.println(count);
		// 方式二：
		Optional<Integer> op = charStream.map(c -> {
			if (c.equals('马')) {
				return 1;
			} else {
				return 0;
			}
		}).reduce(Integer::sum);

		System.out.println(op.get());

		// 练习3：员工姓名中包含“马”的员工个数
		long count = emps.stream().map(Employee::getName).filter(name -> name.contains("马")).count();
		System.out.println(count);

		// 练习4：员工姓名中包含“马”的员工的姓名
		emps.stream().map(Employee::getName).filter(name -> name.contains("马")).forEach(System.out::println);

	}
	
	

	// 1-匹配与查找
	@Test
	public void test2() {
		List<Employee> list = EmployeeData.getEmployees();
		// max(Comparator c)——返回流中最大值
		// 练习：返回最高的工资：
		Stream<Employee> stream = list.stream();
		Stream<Double> stream1 = stream.map(Employee::getSalary);
		Optional<Double> max = stream1.max(Double::compare);
		System.out.println(max.get());
		// min(Comparator c)——返回流中最小值
		// 练习：返回最低工资的员工
		Stream<Employee> stream2 = list.stream();
		Optional<Employee> min = stream2.min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(min.get());
		// forEach(Consumer c)——内部迭代
		list.stream().forEach(System.out::println);

	}

	// 外部迭代
	@Test
	public void test3() {
		List<Employee> list = EmployeeData.getEmployees();
		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void test1() {
		List<Employee> list = EmployeeData.getEmployees();
		// allMatch(Predicate p)——检查是否匹配所有元素
		// 是否所有的员工的年龄都大于18
		boolean b = list.stream().allMatch(e -> e.getAge() > 18);
		System.out.println(b);

		// anyMatch(Predicate p)——检查是否至少匹配一个元素
		// 是否存在员工的工资大于 10000
		boolean b1 = list.stream().anyMatch(e -> e.getSalary() > 9900);
		System.out.println(b1);

		// noneMatch(Predicate p)——检查是否没有匹配的元素
		// 是否存在员工姓“雷”
		boolean b2 = list.stream().noneMatch(e -> e.getName().contains("雷"));
		System.out.println(b2);

		// findFirst——返回第一个元素
		Optional<Employee> emp = list.stream().sorted((e1, e2) -> {
			if (e1.getAge() != e2.getAge()) {
				return e1.getAge() - e2.getAge();
			} else {
				return -Double.compare(e1.getSalary(), e2.getSalary());
			}
		}).findFirst();
		System.out.println(emp.get());

		// findAny——返回当前流中的任意元素
		Optional<Employee> emp1 = list.parallelStream().findAny();
		System.out.println(emp1.get());
		// count——返回流中元素的总个数
		long count = list.stream().filter(e -> e.getSalary() > 5000).count();
		System.out.println(count);

	}
}
