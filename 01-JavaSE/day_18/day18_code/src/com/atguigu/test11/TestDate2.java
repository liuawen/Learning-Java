package com.atguigu.test11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.Test;

/*
 * 二、JDK1.8之后引入了新的日期时间API
 * 旧的问题：
 * （1）偏移性
 * （2）对象的可变性问题
 * 大多数程序员认为，一个日期时间的对象，应该对应一个日期时间的点，不应该变化，
 * 如果想要代表另一个日期时间点，应该用另一个对象来表示。
 * 即对象日期时间对象的修改，应该产生新对象，而不是修改原来的对象。
 * 新版的日期时间对象，不可变，一旦修改会返回新对象。
 * 
 * 不可变对象：String、包装类对象，修改就会新对象
 * 
 * （3）格式化：旧版只支持Date
 * （4）旧版日期时间API：它们也不是线程安全的，不能处理闰秒
 * 
 * 新版的日期时间API对旧版有补充。
 * 
 * 1、基本类型
 * LocalDate：本地日期
 * LocalTime：本地时间
 * LocalDateTime:本地日期时间
 * 
 * 这三个代替原来的java.util.Date和java.util.Calendar
 * 
 * (1)now()
 * (2)of(xx)
 * (3)getXxx()：获取什么值
 * (4)plusXxx：加上什么
 * (5)minusXxx：减去什么
 * (6)isLeapYear()：是否是闰年
 * ...
 * 
 * 2、日期时间格式化
 * 对应于老版：SimpleDateFormat
 * 
 * 
 */
public class TestDate2 {
	@Test
	public void test10(){
		LocalDateTime now = LocalDateTime.now();
		
//		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);//2019年6月6日 下午04时40分03秒
		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);//19-6-6 下午4:40
		String str = df.format(now);
		System.out.println(str);
	}
	@Test
	public void test9(){
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE_TIME;//2019-06-06T16:38:23.756
		String str = df.format(now);
		System.out.println(str);
	}
	
	@Test
	public void test8(){
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒  SSS毫秒  E 是这一年的D天");
		String str = df.format(now);
		System.out.println(str);
	}
	
	@Test
	public void test7(){
		LocalDate now = LocalDate.now();
		LocalDate before = now.minusDays(100);
		System.out.println(before);//2019-02-26
	}
	
	@Test
	public void test06(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		LocalDate go = lai.plusDays(160);
		System.out.println(go);//2019-10-20
	}
	
	@Test
	public void test05(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		System.out.println(lai.getDayOfYear());
	}
	
	
	@Test
	public void test04(){
		LocalDate lai = LocalDate.of(2019, 5, 13);
		System.out.println(lai);
	}
	
	@Test
	public void test03(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}
	
	@Test
	public void test02(){
		LocalTime now = LocalTime.now();
		System.out.println(now);
	}
	
	@Test
	public void test01(){
		LocalDate now = LocalDate.now();
		System.out.println(now);
	}

}
