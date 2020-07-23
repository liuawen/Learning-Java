package com.atguigu.test02;

import java.io.Serializable;
import java.util.ArrayList;

import org.junit.Test;

/*
 * 补充：
 * 4、泛型类或泛型接口上的<泛型形参>这个类型可以用在哪些地方？
 * （1）可以用于属性、方法的数据形参、局部变量等的类型
 * （2）不能用于静态成员上
 * 
 * 5、泛型类或泛型接口的泛型形参，可以设定上限
 * <T extends 上限>
 *   T的类型实参只能上限本身或上限的子类
 *   
 * <T extends 上限1 &  上限2 & 。。。。>
 *   如果多个上限，都要满足
 *  
 * 6、  泛型的形参一般代表什么的类型？
 * ArrayList<E>：这个E代表集合的元素的类型
 * Map<K,V>：这个K代表key的类型，V代表的value的类型
 * Comparable<T>：这个T代表，要与当前对象比较的另一个对象的类型
 * Student<T>：这个T代表成绩的类型
 * 
 * 7、如果在使用泛型类或泛型接口的时候，没有指定泛型实参，会怎么样？
 * 泛型被擦除，泛型被擦除后，泛型形参被解析为什么类型呢？
 * 被解析为泛型形参的第一个上限的类型。
 * (1)如果没有指定泛型形参的上限，就按照Object处理
 * (2)如果指定泛型形参的上限，就按照上限处理，如果有多个上限，多个上限用&连接，按照最左边的第一个上限处理
 */
public class TestGenericClass2 {
	@Test
	public void test02(){
		ArrayList list = new ArrayList();
		list.add("1");//泛型擦除，按照Object处理
		
		XueSheng x = new XueSheng("张三", 89);//XueSheng(String, Number) 
		
		AClass a = new AClass();
		a.test(1);//按照Nubmer处理
	}
	
	@Test
	public void test01(){
//		XueSheng<String> x = new XueSheng<String>("张三","优秀");//错误的，因为String不是Number或Number的子类
		
		XueSheng<Double> x1 = new XueSheng<Double>("张三",89.5);
		XueSheng<Integer> x2 = new XueSheng<Integer>("张三",89);
		XueSheng<Long> x3 = new XueSheng<Long>("张三",89L);
	}
}
//T的上限，
//T的类型实参要求，同时是Number的子类，还要实现Comparable和Serializable接口
class AClass<T extends Number & Comparable & Serializable>{
	public void test(T t){
		
	}
}

/*
 * 自定义一个泛型类：
 * 定义一个“特殊”的学生类，学生类包含两个属性：姓名，成绩
 * 此时成绩的情况很复杂：
 * 语文老师在表示学生时：成绩登记为：87
 * 数学老师在表示学生时：成绩登记为：89.5 ....
 * 
 * <T>：泛型形参
 * T在这个XueSheng当做就是score的类型，凡是需要表示score的类型的地方都用T
 * 
 * 此时想要限定这个T必须是一个数字，不能是字符串等其他类型
 */
class XueSheng<T extends Number>{
	private String name;
	private T score;
	public XueSheng(String name, T score) {
		super();
		this.name = name;
		this.score = score;
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
		return "XueSheng [name=" + name + ", score=" + score + "]";
	}
	
}


class MyClass<T>{
	private T t;//用于当做属性的数据类型
//	private static  T t2;

	public MyClass(T t) {//用于当做方法的数据形参的类型
		super();
		this.t = t;
	}

	//可以用于返回值的类型
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public void test(){
		T t;//局部变量的类型
	}

/*	public static T getT2() {
		return t2;
	}

	public static void setT2(T t2) {
		MyClass.t2 = t2;
	}*/
	
}