package com.atguigu.test05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
 * 通配符：wildcard
 * 通配符：?
 * 1、<?>：代表可以是任意类型
 * 2、<? extends 上限>：?代表是上限或上限的子类
 * 3、<? super 下限>：?代表的是下限或下限的父类
 * 
 * 看java.util.Collections：集合工具类
 * （1）public static boolean disjoint(Collection<?> c1, Collection<?> c2)看c1和c2是否有交集，如果没有交集返回true
 */
public class TestWildcards {
	@Test
	public void test05(){
		Collection<String> src = new ArrayList<String>();
		src.add("hello");
		src.add("world");
		Collection<Integer> dest = new ArrayList<Integer>();
		dest.add(1);
		dest.add(2);
		
	//	copy(src,dest);//把src中的"hello"、"world"添加的dest中，有问题
		
		Collection<Object> dest2 = new ArrayList<Object>();
		copy(src, dest2);//把src中的"hello"、"world"添加的dest2中，没问题    此时T是String，？是Object
	}
	/*
	 * 举例：
	 * 想要声明一个方法，可以把一个Collection集合src中的所有元素，添加到另一个Collection集合dest中
	 */
	public <T> void copy(Collection<T> src, Collection<? super T> dest){
		for (T object : src) {
			dest.add(object);
		}
	}
	
	
	
	@Test
	public void test04(){
		ArrayList<String> list1 = new ArrayList<String>();
//		printGraphic(list1);//错误的因为String不满足<? extends Graphic>
		
		ArrayList<Circle> list2 = new ArrayList<Circle>();
		printGraphic(list2);//因为Circle满足<? extends Graphic>
	}
	
	/*
	 * 举例：
	 * 想要声明一个方法，遍历一个里面装着图形对象的集合
	 */
	public void printGraphic(Collection<? extends Graphic> c){
		for (Graphic graphic : c) {
			System.out.println(graphic);
		}
	}
	
	
	@Test
	public void test03(){
		Collection<String> c1 = new ArrayList<String>();
		c1.add("hello");
		
		Collection<Integer> c2 = new ArrayList<Integer>();
		c2.add(1);
		
		System.out.println(Collections.disjoint(c1, c2));
	}
	
	@Test
	public void test01(){
		List<Integer> list = Arrays.asList(1,2,3,4);
		print(list);
	}
	
	/*
	 * 声明一个方法：这个方法可以用于遍历所有的Collection系列的集合
	 * 此时因为Collection是一个泛型接口，Collection<E>
	 * 如果此时不指定<E>的具体类型，会报警告，（1）方式一，抑制警告（2）方式二：用?来代表任意类型
	 * 因为此时不知道要被遍历的集合的元素类型是什么
	 */
	public void print(Collection<?> c){
		for (Object object : c) {
			System.out.println(object);
		}
	}
	
	//以前我们说Object可以接收任意类型对象，但是不代表Collection<Object>可以接收任意泛型实参的集合
	//Collection<Object>这么写，只能接收Collection<Object>,List<Object>...，即泛型实参必须是<Object>
/*	public void print(Collection<Object> c){
		for (Object object : c) {
			System.out.println(object);
		}
	}*/
	
	@Test
	public void test2(){
		Object str = new String();//是多态
//		ArrayList<Object> list = new ArrayList<String>();//错误的，不是多态
		
		ArrayList<Object> list1 = new ArrayList<Object>();
		ArrayList<String> list2 = new ArrayList<String>();
	}
}
//图形类
class Graphic{
	//...
}
//圆类
class Circle extends Graphic{
	//...
}
//矩形类
class Rectangle extends Graphic{
	//...
}