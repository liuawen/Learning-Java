package com.atguigu.test02;

import java.util.ArrayList;

import org.junit.Test;

/*
 * 泛型的使用形式有2种：
 * 1、泛型类\泛型接口
 * 2、泛型方法
 * 
 * 一、泛型类/接口
 * 1、语法格式：
 * 【修饰符】  class  类名<泛型形参列表>{
 * }
 * 【修饰符】  interface  接口名<泛型形参列表>{
 * }
 * 
 * 例如：
 * public interface Collection<E>  <E>就是泛型形参列表
 * public class ArrayList<E>       <E>就是泛型形参列表
 * public class HashMap<K,V>	   <K,V>就是泛型形参列表
 * 我们看到在声明类或接口时，<E>,<K,V>,<T>,<U>....都是泛型的形参列表
 * 这些E，K，V,T等代表的是某种元素的类型
 * 
 * ArrayList<String> list = new ArrayList<String>();
 * 此时：<String>泛型的实参列表
 * 
 *  //存储本组学员的姓名(key)和它的年龄(value)
 * HashMap<String,Integer> map = new HashMap<String,Integer>();
 *  此时：<String,Integer>是泛型的实参列表
 *  
 *  2、要求
 *  泛型实参必须是一个引用数据类型，不能是基本数据类型
 *  
 *  3、如何为泛型类、泛型接口指定泛型实参
 *  （1）创建泛型类的对象时 
 *  Student<String> chinese = new Student<String>("张三","优秀");
 *  （2）继承泛型类、泛型接口时可以指定泛型实参
 *  class ChineseStudent extends Student<String>
 *  （3）实现泛型接口时，可以指定泛型实参
 *  class Employee implements Comparable<Employee>
 */  
public class TestGenericClass {
	@Test
	public void test1(){
//		ArrayList<int> list = new ArrayList<int>();//错误
		ArrayList<Integer> list = new ArrayList<Integer>();//对
	}
	
	@Test
	public void test2(){
		//语文老师
		Student<String> chinese = new Student<String>("张三","优秀");
		
		//数学老师
		Student<Double> math = new Student<Double>("张三",89.5);
		
		//英语老师
		Student<Character> english = new Student<Character>("张三",'A');
	}
	
	
	@Test
	public void test3(){
		//语文老师
		ChineseStudent c = new ChineseStudent("张三","优秀");
	}
}

/*
 * 自定义一个泛型类：
 * 定义一个“特殊”的学生类，学生类包含两个属性：姓名，成绩
 * 此时成绩的情况很复杂：
 * 语文老师在表示学生时：成绩登记为：优秀、良好、及格、不及格
 * 数学老师在表示学生时：成绩登记为：89.5 ....
 * 英语老师在表示学生时：成绩登记为：A,B,C,D...
 * 
 * <T>：泛型形参
 * T在这个Student当做就是score的类型，凡是需要表示score的类型的地方都用T
 */
class Student<T>{
	private String name;
	private T score;
	public Student(String name, T score) {
		super();
		this.name = name;
		this.score = score;
	}
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getScore() {
		return score;
	}
	public void setScore(T score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
}
//语文老师
class ChineseStudent extends Student<String>{

	public ChineseStudent() {
		super();
	}

	public ChineseStudent(String name, String score) {
		super(name, score);
	}
	
}

//接口：java.lang.Comparable<T>
class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}
	
}