package com.atguigu.test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/*
 * 二、泛型方法
 * 1、什么情况需要声明泛型方法？
 * （1）如果某个静态方法想要使用泛型，需要单独设计
 * 例如：java.util.Arrays数组工具类
 * public static <T> List<T> asList(T... a)
 * 		T...是可变参数
 * 
 * （2）如果泛型类或泛型接口上的泛型形参不适用于某一个方法（可以是静态的，也可以是非静态），那么这个方法，可以单独设计泛型
 * 例如：java.util.Collection<E>
 * public abstract <T> T[] toArray(T[] a)
 * 
 * 2、泛型方法的语法格式
 * 【修饰符】 <泛型形参列表> 返回值类型  方法名(【数据形参列表】)
 * 
 * 3、泛型方法的<泛型形参列表>这个类型就用于当前方法的形参类型、返回值类型、局部变量，和其他方法无关
 * 
 * 4、泛型方法的类型形参，什么时候指定类型实参
 * 当你调用这个方法时，编译器会根据方法的实参的类型，来确定泛型的类型实参的具体类型
 * 
 * 5、泛型方法的<泛型形参列表>中的类型也可以指定上限
 * <T extends 上限>
 *   T的类型实参只能上限本身或上限的子类
 *   
 * <T extends 上限1 &  上限2 & 。。。。>
 *   如果多个上限，都要满足
 */
public class TestGenericMethod {
	public <T extends Number> T test(T t){
		//...
		return t;
	}
	
	@Test
	public void test03(){
		Integer num = test(1);
		
		Double d = test(1.0);
		
//		test("hello");//错的，因为String不符合Number的上限
	}
	
	@Test
	public void test02(){
		Collection<String> c = new ArrayList<String>();
		c.add("张三");
		c.add("李四");
		
		String[] arr = new String[2];
		String[] array = c.toArray(arr);//根据arr的数组类型，来确定返回值的T[]的类型
		
		Object[] all = new Object[2];
		Object[] array2 = c.toArray(all);//根据all的数组类型，来确定返回值的T[]的类型
	}
	
	@Test
	public void test01(){
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);//根据1,2,3,4,5可以确定T是Integer类型
		
		List<String> list2 = Arrays.asList("hello","java");//根据"hello","java"确定T是String类型
		
	}
}
