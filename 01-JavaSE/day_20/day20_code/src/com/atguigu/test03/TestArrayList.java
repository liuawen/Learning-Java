package com.atguigu.test03;

import java.util.ArrayList;

/*
 * ArrayList动态数组：源码跟踪
 * (1)new ArrayList()：
 * JDK1.8版本：发现内部初始化为了一个长度为0的空数组  DEFAULTCAPACITY_EMPTY_ELEMENTDATA
 * JDK1.7版本：也是初始化为长度为0的空数组  EMPTY_ELEMENTDATA;	
 * JDK1.6版本：初始化为长度为10的数组
 * 
 * 为什么要初始化为空数组呢？
 * 因为开发中，很多时候创建了ArrayList的对象，但是没有装元素，这个时候的话，如果初始化为10的数组，就浪费空间了。
 * 
 * (2)add(Object e）
 *JDK1.8 第一次添加元素，扩容为长度为10的数组
 *JDK1.8  如果不够了，再扩容为1.5倍
 *
 *
 */
@SuppressWarnings("all")
public class TestArrayList {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("hello");
		list.add("java");
		list.add("chai");
		list.add("lin");
		
		ArrayList all = getAll(list);
		System.out.println(all);
	}
	
	/*
	 * 这个方法，是一个查询的方法，把查询结果返回
	 * 例如：查询list中，字符串长度超过5个字符串
	 */
	public static ArrayList getAll(ArrayList list){
		//....
		ArrayList result = new ArrayList();
		for (Object object : list) {
			String str= (String) object;
			if(str.length()>5){
				result.add(str);
			}
		}
		return result;
	}
}
