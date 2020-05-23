package com.atguigu.test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

/*
 * 数据结构，容器：
 * 	 用来装对象....，等各种管理对象的容器。
 * 
 * 容器有相同的操作标准：
 * （1）增
 * （2）删
 * （3）改
 * （4）查
 * ...
 * 
 * Java给这些集合抽取两大接口：
 * 1、Collection：
 * 		规范单值集合的接口，obj   --》单身party
 * 2、Map
 * 		规范对值集合的接口，(key,value)  -->情侣party
 * 
 * 一、Collection
 * 1、Collection：接口
 * （1）它是根接口
 * （2）它没有直接的实现类，有更具体的子接口：List和Set...
 * （3）有一些的元素是可以重复的，有些集合的元素是不能重复，有些集合的元素是有序的，有些集合的元素是无序的
 * 
 * 2、API
 * （1）添加
 * add(Object obj)：添加一个元素
 * addAll(Collection c)：添加多个元素
 * （2）获取有效元素的个数
 * int size()
 * （3）是否包含
 * contains(Object o) ：判断o是否在当前的集合中
 * containsAll(Collection c) ：判断c是否是当前集合的子集
 * （4）boolean isEmpty()  ：判断当前集合是否为空
 * 等价于   集合对象.size()==0
 * （5）remove(Object o)：删除一个
 * removeAll(Collection c)：删除多个      this = this - this ∩ c
 * clear()：清空所有
 * 
 * （6）retainAll(Collection<?> c) ：保留交集   this = this ∩ c
 * （7）Object[] toArray()  ：把集合中的元素用一个数组返回
 */
public class TestCollection {
	@SuppressWarnings("all")
	@Test
	public void test9(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		Object[] all = c.toArray();
		System.out.println(Arrays.toString(all));
	}
	
	@SuppressWarnings("all")
	@Test
	public void test8(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c2.add("张三");
		c2.add("杨洪强");
		
		c.retainAll(c2);
		System.out.println(c);
		System.out.println(c2);
	}
	
	@SuppressWarnings("all")
	@Test
	public void test7(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c2.add("张三");
		c2.add("杨洪强");
		
		c.removeAll(c2);
		System.out.println(c);//说明ArrayList重写了toString
	}
	
	@SuppressWarnings("all")
	@Test
	public void test6(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c2.add("张三");
		c2.add("李四");
		
		c.removeAll(c2);
		System.out.println(c);//说明ArrayList重写了toString
	}
	
	
	@SuppressWarnings("all")
	@Test
	public void test5(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		c.remove("张三");//删除一个
		System.out.println(c);//说明ArrayList重写了toString
	}
	
	@SuppressWarnings("all")
	@Test
	public void test4(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c2.add("张三");
		c2.add("李四");
		
		Collection c3 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c3.add("张三");
		c3.add("杨洪强");
		
		System.out.println(c.containsAll(c2));//c2是c的子集
		System.out.println(c.containsAll(c3));//c3不是c的子集
	}
	
	@SuppressWarnings("all")
	@Test
	public void test3(){
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		System.out.println(c.contains("张三"));
		System.out.println(c.contains("杨洪强"));
	}
	
	@SuppressWarnings("all")
	@Test
	public void test2(){
		/*
		 * 我这里左边写Collection，目的是只关注Collection
		 * 因为多态引用时，c编译期间只能访问Collection的方法
		 */
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c.add(1);
		c.add(2);
		c.add(3);
		
		Collection c2 = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		c2.add("张三");
		c2.add("李四");
		c2.add("王五");
		
		c.addAll(c2);//把c2中的所有元素都添加到c集合中
//		c.add(c2);
		
		System.out.println("获取有效元素的个数：" + c.size());
		System.out.println(c);
	}
	
	
	@SuppressWarnings("all")
	@Test
	public void test1(){
		/*
		 * 我这里左边写Collection，目的是只关注Collection
		 * 因为多态引用时，c编译期间只能访问Collection的方法
		 */
		Collection c = new ArrayList();//ArrayList是Collection下面的一个实现类而已
		
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		System.out.println("获取有效元素的个数：" + c.size());
	}
}
