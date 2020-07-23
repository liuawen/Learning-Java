package com.atguigu.test06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/*
 * java.util.Collections工具类：
 * （1）public static <T> boolean addAll(Collection<? super T> c,T... elements)：把elements这些元素添加到c这个集合中
 * （2）public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)：在list集合中找出key，用二分查找法
 * 		此时要求list集合是有大小顺序
 *	 <? extends Comparable<? super T>>：list集合中的元素必须是实现Comparable接口，?可以是T或T的父类，这个父类实现现Comparable接口也可以
 *
 * （3）public static <T> int binarySearch(List<? extends T> list,T key,Comparator<? super T> c)
 * 		此时要求list集合是有大小顺序的，按照你指定的Comparator进行比较大小
 * <? extends T>：是T或T的子类，说明list中存的元素是T类型的对象或T类型的子类对象
 * <? super T>：这个比较器是为T或T的父类设计的比较器也可以
 * 
 * （4）public static <T> void copy(List<? super T> dest,List<? extends T> src)：把src的元素复制到dest
 * 	src中存的是T或T的子类的对象
 *  dest要求元素类型是T或T的父类类型
 *  
 * （5）public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) 
 * <T extends Object & Comparable<? super T>>是max方法的泛型形参列表，泛型形参T，设定了上限，说明T必须继承Object并且要实现Comparable接口
 * max方法用于在coll集合中找出最大的元素，要求这个元素可比较大小，所以 要求T元素实现Comparable接口
 * 
 * <? extends T>：coll集合中存的是T或T的子类的对象
 * 
 * （6）public static <T> T max(Collection<? extends T> coll,Comparator<? super T> comp)
 * 如果coll中的元素不支持自然比较大小，那么用comp这个定制比较器比较元素的大小
 * 
 * （7）public static void reverse(List<?> list)：可以反转任意的List集合元素 
 * 
 * （8）public static void shuffle(List<?> list)：类似于洗牌
 * 
 * （9）public static <T> Set<T> singleton(T o)：返回一个只有一个元素的Set集合
 * 
 * （10）public static <T extends Comparable<? super T>> void sort(List<T> list)：用于给List集合排序
 * <T extends Comparable<? super T>>要求集合中的元素实现Comparable接口
 * 
 * （11）public static <T> void sort(List<T> list, Comparator<? super T> c)：可以按照定制比较器排序
 * 
 * （12）public static void swap(List<?> list,int i,int j)：交换list中[i]与[j]位置的元素，List<?>代表集合的元素可以是任意类型
 * 
 * （13）public static <T> List<T> synchronizedList(List<T> list)：可以把一个线程不安全的list集合变成一个线程安全的list集合
 * 。。。
 * （14）public static <T> List<T> unmodifiableList(List<? extends T> list)：把list集合变成一个不可修改的集合，只读的集合
 * 
 */
public class TestCollections {
	@Test
	public void test5(){
		List<Integer> list = Arrays.asList(1,2,3,4);
		System.out.println(list);
		
		//说明list是一个只读的集合
//		list.add(5);//UnsupportedOperationException
		System.out.println(list.getClass());//class java.util.Arrays$ArrayList不是java.util.ArrayList
	}
	
	@Test
	public void test4(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		Collections.shuffle(list);
		
		System.out.println(list);
	}
	
	@Test
	public void test3(){
		ArrayList<SubCircle> list = new ArrayList<SubCircle>();
		list.add(new SubCircle(1.2));
		list.add(new SubCircle(2.2));
		list.add(new SubCircle(3.2));
		
		//T是Circle类型
		//因为Graphic是Circle的父类，<? super T>
		//SubCircle是Circle的子类，满足<? extends T>
		Collections.binarySearch(list, new Circle(2.2), new Comparator<Graphic>(){

			@Override
			public int compare(Graphic o1, Graphic o2) {
				if(o1.getArea() > o2.getArea()){
					return 1;
				}else if(o1.getArea() < o2.getArea()){
					return -1;
				}
				return 0;
			}
			
		});
	}
	
	@Test
	public void test2(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(9);
		
		//此时的T是Integer
		//list的<Integer>，这个Integer
		int index = Collections.binarySearch(list, 4);
	}
	
	@Test
	public void test1(){
		//元素是1,2,3,4
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<Object> list3 = new ArrayList<Object>();
		ArrayList<Number> list4 = new ArrayList<Number>();
		
		//此时T是Integer类型，
		//<? super T>：可以是Integer或它的父类
		Collections.addAll(list, 1,2,3,4);
		
		//此时T是Integer类型，
		//因为String不满足<? super T>
//		Collections.addAll(list2, 1,2,3,4);
		
		//此时T是Integer类型，
		//Object满足<? super T>
		Collections.addAll(list3, 1,2,3,4);
		
		//此时T是Integer类型，
		//Nubmer满足<? super T>
		Collections.addAll(list4, 1,2,3,4);
	}
}
abstract class Graphic{
	public abstract double getArea();
}
class Circle extends Graphic{
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}
class SubCircle extends Circle{

	public SubCircle(double radius) {
		super(radius);
		
	}
}