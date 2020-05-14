package com.atguigu.datetime;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * jdk 8 之前 日期+时间 API的使用
 * 
 * 
 * @author shkstart 邮箱：shkstart@126.com
 * @version  创建时间：2017年8月15日  上午11:37:44
 *
 */
public class TimeTest {
	
	@Test
	public void test(){
		Date date = new Date(2017 - 1900, 11 - 1, 5);
		System.out.println(date);
	}
	
	
	/**
	 * java.util.Calendar(日历)类的使用
	 * 
	 * 
	 * @author shkstart 邮箱：shkstart@126.com
	 * @throws ParseException
	 */
	@Test
	public void test4(){
		//1.实例化
		Calendar calendar = Calendar.getInstance();
		
		//get()
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		//set()
		calendar.set(Calendar.DAY_OF_MONTH, 20);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		//add()
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		//日历 --->日期
		Date date = calendar.getTime();
		System.out.println(date);
		
		//使用指定的Date对象，来设置calendar
		Date date1 = new Date();
		calendar.setTime(date1);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
	}
	
	/*
	 * 练习一：
	 * 如何将字符串的"2014-1-16"数据转换为java.sql.Date对象？
	 * 
	 * 
	 * 练习二：“三天打渔，两天晒网”  从 1990-1-1开始实施。
	 *       判断1990-1-1之后xxxx-xx-xx日是打渔？晒网？
	 *       比如：2017-08-15
	 * 方式一：1990-1-1  ---> 2016-12-31  +     2017-1-1 ----->2017-8-15   计算出总天数
	 *      计算的总天数为sumDays.
	 *      sumDays % 5 == 1,2,3 :打渔
	 *      sumDays % 5 == 4,0 :晒网
	 * 
	 * 方式二：1990-1-1   ---->java.util.Date: date1
	 *       2017-08-15  ------>java.util.Date :date2
	 * 
	 *      sumDays = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
	 * 
	 * 
	 */
	@Test
	public void testExer() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String info = "2014-1-16";
		Date date = sdf.parse(info);
		
//		System.out.println(date);
		
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		System.out.println(date1);
		
	}
	
	/**
	 * java.text.SimpleDateFormat类
	 * 
	 * 1.SimpleDateFormat的作用：
	 *   格式化：日期--->文本
	 *   解析：格式化的逆过程，文本 --->日期
	 * 
	 * 2.SimpleDateFormat实例化
	 * @throws ParseException 
	 * 
	 */
	@Test
	public void test3() throws ParseException{
		//1.使用默认构造器
		SimpleDateFormat sdf = new SimpleDateFormat();
		//格式化：String format(Date date):
		Date date = new Date();
		String dateStr = sdf.format(date);
		System.out.println(dateStr);//17-8-15 下午2:20
		
		//解析： Date parse(String dateStr)
		Date date1 = sdf.parse("17-8-15 下午2:18");
		System.out.println(date1);
		
		//2.使用带参数的构造器
//		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//格式化
		String dateStr1 = sdf1.format(date);
		System.out.println(dateStr1);//2017-08-15 02:24:40
		
		//解析
		Date date2 = sdf1.parse("2017-08-15 02:24:40");
		System.out.println(date2);
		
	}
	
	/**
	 * java.util.Date类
	 * 		|----java.sql.Date类
	 * 
	 * 1.java.util.Date类：
	 *    如何实例化：两个构造器
	 *    常用方法：toString() / getTime();
	 * 
	 * 2.java.sql.Date类：与数据表中的Date类型的变量对应。
	 * 		
	 * 
	 * @author shkstart 邮箱：shkstart@126.com
	 */
	@Test
	public void test2(){
		
		//构造器一：获取系统当前时间对应的Date对象
		Date date = new Date();
		
		System.out.println(date.toString());
		//getTime()：返回当前日期对应的毫秒数：当前时间与1970-1-1 00：00：00直接的毫秒数
		System.out.println(date.getTime());
		
		//构造器二：获取毫秒数所对应的Date对象
		Date date1 = new Date(1502768492941L);
		System.out.println(date1);
		
		System.out.println("************如下的是java.sql.Date*********************");
		//实例化：
		java.sql.Date date2 = new java.sql.Date(1502768492941L);
		System.out.println(date2.toString());//2017-08-15
		System.out.println(date2.getTime());
		
		//小练习：如何将java.util.Date转换为java.sql.Date
		//情形一：
		Date date3 = new java.sql.Date(153145234532L);
//		date3 = new Date();//会报异常
		java.sql.Date date4 = (java.sql.Date) date3;
		System.out.println(date4);
		
		//情形二：
		System.out.println();
		Date date5 = new Date();
		java.sql.Date date6 = new java.sql.Date(date5.getTime());
		System.out.println(date6);
		
		
	}
	
	@Test
	public void test1(){
		//用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
	}
	
	
}
