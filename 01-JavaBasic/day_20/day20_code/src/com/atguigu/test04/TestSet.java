package com.atguigu.test04;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.junit.Test;

/*
 * Collection是根接口，没有提供任何直接实现的。它有一些更具体的子接口，例如：List和Set。
 * 
 * 一、Set接口
 * 1、Set系列的集合的元素是不能重复的。
 * 2、Set的实现类们：HashSet、TreeSet、LinkedHashSet
 *   Set：如果按照元素的存储顺序来说，有一些是可以保证的，有一些是不能保证的。唯有LinkedHashSet可以保证元素添加的顺序。
 *   	 如果按照元素的大小顺序来说，有一些是可以保证的，有一些是不能保证的。唯有TreeSet可以保证元素的大小顺序。
 *   其中HashSet：既不能保证添加顺序，也不能保证大小顺序。是完全无序的。
 *   
 *    List：有序的，可重复的
 *    		有序的：前后顺序，可能是[下标]索引顺序，也可以能是链表的next,prev的引用顺序。
 * 3、Set接口没有增加方法，都是从Collection接口中继承的。
 * 
 * 4、HashSet和LinkedHashSet
 * HashSet：完全无序
 * LinkedHashSet：添加顺序
 * LinkedHashSet是HashSet的子类，比HashSet多维护了添加的顺序。
 *    当你既想要实现集合的元素的不可重复性，又想要保证元素的添加顺序，就选择使用LinkedHashSet。否则就用List系列或HashSet。
 * LinkedHashSet干的事多了，效率低了。
 * 
 * 5、HashSet和TreeSet
 *  HashSet：完全无序
 *  TreeSet：大小顺序
 *  当你需要元素不可重复，又要给元素排大小时，就用TreeSet。
 *  
 *  要用到TreeSet，一定要用java.lang.Comparable或java.util.Comparator
 *  
 * 6、如何保证元素不可重复的？
 * 换句话说，如何判断两个元素是重复的呢？
 *  HashSet和LinkedHashSet：
 *  		①先比较hash值，如果hash值不一样，说明一定不相同，
 *  		②如果hash值一样，再调用equals方法比较
 *  
 *  TreeSet:
 *  	按照元素的大小来决定是否相同元素。
 */
@SuppressWarnings("all")
public class TestSet {
	@Test
	public void test12(){
		//存储到TreeSet的元素不会用它的hashCode和equals
		//认为大小“相等”就是相同的元素
		TreeSet set = new TreeSet(new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				return s1.getId() - s2.getId();
			}});
		Student s1 = new Student(3,"张三");
		Student s2 = new Student(1,"李四");
		Student s3 = new Student(2,"王五");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set);
	}
	
	@Test
	public void test11(){
		//存储到HashSet的元素会用它的hashCode和equals
		HashSet set = new HashSet();
		Student s1 = new Student(3,"张三");
		Student s2 = new Student(1,"李四");
		Student s3 = new Student(2,"王五");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
	}
	
	@Test
	public void test10(){
		//用匿名内部类实现了Comparator接口
		TreeSet set = new TreeSet(new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;
				return s1.getId() - s2.getId();
			}});
		
		set.add(new Student(3,"张三"));
		set.add(new Student(1,"李四"));
		set.add(new Student(2,"王五"));
		
		System.out.println(set);
	}
	
	@Test
	public void test9(){
		TreeSet set = new TreeSet();
		//这里因为Object类型没有实现了java.lang.Comparable接口，所以不可以添加到TreeSet中
		set.add(new Object());
	}
	@Test
	public void test8(){
		TreeSet set = new TreeSet();
		//这里因为String类型实现了java.lang.Comparable接口，所以可以添加到TreeSet中
		set.add("hello");
		set.add("world");
		set.add("java");
		set.add("chailinyan");
	}
	
	//顺序：TreeSet大小顺序
	@Test
	public void test7(){
		TreeSet set = new TreeSet();
		set.add("hello");
		set.add("world");
		set.add("java");
		set.add("chailinyan");
		
		System.out.println(set);//[chailinyan, hello, java, world]
	}
	
	//顺序：LinkedHashSet添加顺序
	@Test
	public void test6(){
		LinkedHashSet set = new LinkedHashSet();
		set.add("hello");
		set.add("world");
		set.add("java");
		set.add("chailinyan");
		
		System.out.println(set);//[hello, world, java, chailinyan]
	}
	
	//顺序：HashSet无序
	@Test
	public void test5(){
		HashSet set = new HashSet();
		set.add("hello");
		set.add("world");
		set.add("java");
		set.add("chailinyan");
		
		System.out.println(set);//[world, java, chailinyan, hello]
	}
	
	//顺序：HashSet无序
	@Test
	public void test4(){
		HashSet set = new HashSet();
		set.add("张三");
		set.add("李四");
		set.add("王五");
		set.add("柴林燕");
		
		System.out.println(set);//[李四, 柴林燕, 张三, 王五]
	}
	
	
	//不可重复
	@Test
	public void test2(){
		LinkedHashSet set = new LinkedHashSet();
		set.add("张三");
		set.add("张三");
		set.add("李四");
		
		System.out.println(set);
	}
	
	//不可重复
	@Test
	public void test3(){
		TreeSet set = new TreeSet();
		set.add("张三");
		set.add("张三");
		set.add("李四");
		
		System.out.println(set);
	}
	
	//不可重复
	@Test
	public void test1(){
		HashSet set = new HashSet();
		set.add("张三");
		set.add("张三");
		set.add("李四");
		
		System.out.println(set);
	}
}
class Student{
	private int id;
	private String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
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
	public int hashCode() {
		System.out.println("Student的hashCode方法");
		/*final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;*/
		return 1111;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Student的equals方法");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}