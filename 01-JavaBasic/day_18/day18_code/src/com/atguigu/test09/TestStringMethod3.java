package com.atguigu.test09;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;

/*
 * 方式系列三：和byte相关，或者说和编码与解码相关
 * （1）byte[]  getBytes()：编码的方法，使用平台默认的字符编码进行编的
 * byte[]  getBytes(编码方式)：
 * 
 * 编码：对于ASCII码范围内（0~127），无论用什么编码方式，结果都是一样的，一个字符对应一个字节的编码值
 * 	        对于其他的字符，编码，结果不一定是几个字节，例如汉字：
 * 		UTF-8：变长的，但是大多数汉字都是3个字节
 * 		GBK、GB2312：固定2个字节
 * 		ISO8859-1：不支持中文，所有字符都变为1个字节
 * （2）new String(字节数组)
 * new String(字节数组，编码方式)
 * 
 * 编码：
 * 	 把字符-->字节的过程，编给计算机用的
 * 解码：
 * 	把字节-->字符的过程，解给人看的
 * 
 * 乱码：
 * （1）编码与解码字符集不一致
 * （2）缺字节
 */
public class TestStringMethod3 {
	@Test
	public void test05() throws UnsupportedEncodingException{
		String str = "尚硅谷";
		byte[] bytes = str.getBytes("ISO8859-1");
		System.out.println(Arrays.toString(bytes));//[63, 63, 63]
		
		String string = new String(bytes,"ISO8859-1");
		System.out.println(string);
	}
	
	
	@Test
	public void test04() throws UnsupportedEncodingException{
		String str = "尚硅谷";
		byte[] bytes = str.getBytes("GBK");
		System.out.println(Arrays.toString(bytes));//[-55, -48, -71, -24, -71, -56]
		
		String string = new String(bytes,"GBK");
		System.out.println(string);
	}
	
	@Test
	public void test03() throws UnsupportedEncodingException{
		String str = "尚硅谷";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));//[-27, -80, -102, -25, -95, -123, -24, -80, -73]
	
		String string = new String(bytes,"UTF-8");
		System.out.println(string);
	}
	
	@Test
	public void test02(){
		String str = "abc";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));//[97, 98, 99]
	}
	
	@Test
	public void test01(){
		String str = "a";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));//[97]
	}
}
