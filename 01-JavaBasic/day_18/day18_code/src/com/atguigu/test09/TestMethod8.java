package com.atguigu.test09;

import org.junit.Test;

/*
 * 方法系列（8）：替换
 * （1）String replace(target, value)
 * （2）String replaceAll(String regex, String replacement)
 * （3）String replaceFirst(String regex, String replacement)
 * 其中（2）和（3）支持正则
 */
public class TestMethod8 {
	
	@Test
	public void test4(){
		String str = "hello244world.java;887";
		//把其中的非字母去掉
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println(str);
	}
	@Test
	public void test3(){
		String str = "中国共产党是执政党，中国共产党是领导党";
		str = str.replaceAll("共产党", "***");
		System.out.println(str);
	}
	
	@Test
	public void test2(){
		String str = "中国共产党是执政党，中国共产党是领导党";
		str = str.replaceFirst("共产党", "***");
		System.out.println(str);
	}
	
	
	@Test
	public void test1(){
		String str = "中国共产党是执政党，中国共产党是领导党";
		str = str.replace("共产党", "***");
		System.out.println(str);
	}
}
