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
		String str = "ABC码出个未来abc;123";
		//把其中的非字母去掉
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println(str);//ABCabc
	}
	@Test
	public void test3(){
		String str = "飞出个未来，计算灵光点，码出个未来。";
		str = str.replaceAll("未来", "***");
		System.out.println(str);//飞出个***，计算灵光点，码出个***。
	}
	
	@Test
	public void test2(){
		String str = "飞出个未来，计算灵光点，码出个未来。";
		str = str.replaceFirst("未来", "***");
		System.out.println(str);//飞出个***，计算灵光点，码出个未来。
	}
	
	
	@Test
	public void test1(){
		String str = "飞出个未来，计算灵光点，码出个未来。";
		str = str.replace("未来", "**");
		System.out.println(str);//飞出个**，计算灵光点。
	}
}
