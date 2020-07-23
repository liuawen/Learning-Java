package com.atguigu.test10;

import org.junit.Test;

/*
 * 字符串的兄弟类：
 * 
 * String：不可变对象。一旦修改就会有新对象。
 * 引入：可变字符序列，StringBuffer和StringBuilder
 * 
 * StringBuilder默认的char[]长度为16；
 * 		不够了，扩容为原来的2倍+2
 * 
 * StringBuffer和StringBuilder：
 * StringBuffer线程安全的
 * StringBuilder线程不安全的，JDK1.5引入
 * 
 * 方法：
 * （1）append(xx)：拼接，连接
 * （2）insert(index,xxx)：在index位置插入xx
 * （3）delete(int start, int end)：删除[start,end)范围内
 * （4）deleteCharAt(int index)：删除[index]位置
 * （5）reverse()：反转
 * （6）setCharAt(int index, char ch)：替换[index]位置的字符为ch
 * （7）setLength(int newLength) 
 * （8）substring(int start, int end)：截取
 * （9）indexOf(String str) 
 （10）lastIndexOf(String str)
 .....
 */
public class TestStringBuilderBuffer {
	@Test
	public void test6(){
		StringBuilder s = new StringBuilder("helloworld");
		System.out.println(s);//helloworld
		s.setLength(30);
		System.out.println(s);//helloworld
		System.out.println(s.length());//30
		s.setLength(5);
		System.out.println(s);//hello
	}
	@Test
	public void test5(){
		StringBuilder s = new StringBuilder("helloworld");
		System.out.println(s);//helloworld
		s.setCharAt(2, 'a');
		System.out.println(s);//healoworld
	}
	
	
	@Test
	public void test4(){
		StringBuilder s = new StringBuilder("helloworld");
		s.reverse();
		System.out.println(s);//dlrowolleh
	}
	
	@Test
	public void test3(){
		StringBuilder s = new StringBuilder("helloworld");
		s.delete(1, 3);
		System.out.println(s);//helloworld hloworld el
		s.deleteCharAt(4);
		System.out.println(s);//hlowrld
	}
	
	
	@Test
	public void test2(){
		StringBuilder s = new StringBuilder("helloworld");
		s.insert(5, "java");
		System.out.println(s);//hellojavaworld
		s.insert(5, "牛菜鸟");
		System.out.println(s);//hello牛菜鸟javaworld
	}
	
	@Test
	public void test1(){
		StringBuilder s = new StringBuilder();
		s.append("hello").append(12345).append('a').append(false).append("菜鸡文");
		System.out.println(s);//hello12345afalse菜鸡文
		System.out.println(s.length());//19
	}
}
