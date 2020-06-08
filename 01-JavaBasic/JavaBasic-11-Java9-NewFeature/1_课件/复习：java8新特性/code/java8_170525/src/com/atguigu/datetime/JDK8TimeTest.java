package com.atguigu.datetime;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.junit.Test;

public class JDK8TimeTest {

	// 1. LocalDate / LocalTime / LocalDateTime
	//替换原有的Calendar
	@Test
	public void test1() {
		// 实例化
		// now():当前的时间
		LocalDate localDate = LocalDate.now();

		LocalTime localTime = LocalTime.now();

		LocalDateTime localDateTime = LocalDateTime.now();

		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);

		// of()：获取指定的时间
		LocalDate localDate2 = LocalDate.of(2017, 8, 15);
		System.out.println(localDate2);

		LocalDateTime localDateTime2 = LocalDateTime.of(2017, 8, 15, 11, 11, 23);
		System.out.println(localDateTime2);
		System.out.println();
		
		// getXxx():
		System.out.println(localDateTime.getDayOfYear());
		System.out.println(localDateTime.getDayOfMonth());
		System.out.println(localDateTime.getDayOfWeek());
		System.out.println(localDateTime.getMonth());
		System.out.println(localDateTime.getMonthValue());
		System.out.println(localDateTime.getHour());
		System.out.println(localDateTime.getMinute());
		System.out.println();
		
		// withXxx():体现了不可变性
		LocalDateTime localDateTime3 = localDateTime.withDayOfMonth(20);
		System.out.println(localDateTime);
		System.out.println(localDateTime3);

		LocalDateTime localDateTime4 = localDateTime.withHour(12);
		System.out.println(localDateTime4);

		// plus()
		// minus()
		LocalDateTime localDateTime5 = localDateTime.plusDays(3);
		System.out.println(localDateTime5);

		LocalDateTime localDateTime6 = localDateTime.minusMinutes(20);
		System.out.println(localDateTime6);

	}

	// 2. Instant:时间点
	//替换原有的Date
	@Test
	public void test2() {
		// now():得到Instant的实例
		Instant instant = Instant.now();// 表示自1970年1月1日0时0分0秒（UTC）开始的秒数
		System.out.println(instant);

		// atOffset():得到带偏移量的日期时间
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime);

		// 得到时间戳
		long milli = instant.toEpochMilli();
		System.out.println(milli);// 
		

		// 根据毫秒数，得到时间点的对象
		Instant instant2 = Instant.ofEpochMilli(milli);
		System.out.println(instant2);
		
		
		Date date = new Date();//被76行替代
		Date date1 = new Date(3252345324534L);//被89行替代
	}

	// 3.DateTimeFormatter:日期时间的格式化工具
	//替换原有的SimpleDateFormat
	//格式化：日期 ---> 字符串
	//解析：字符串 ---> 日期
	@Test
	public void test3() {
		//方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime localDateTime = LocalDateTime.now();
		String formatDateTime = dateTimeFormatter.format(localDateTime);
		System.out.println(formatDateTime);

		//方式二：本地化相关的格式。如：ofLocalizedDateTime()
		// FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
		LocalDateTime localDateTime1 = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		// 格式化：DateTime ---->文本
		String formatDateTime1 = dateTimeFormatter1.format(localDateTime1);
		System.out.println(formatDateTime1);
		
		// 本地化相关的格式。如：ofLocalizedDate()
		// FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		String formatDateTime2 = format.format(localDate);
		System.out.println(formatDateTime2);
		
		// 解析:文本 --->DateTime
		TemporalAccessor temporalAccessor = dateTimeFormatter1.parse("17-11-5 上午1:03");
		System.out.println(temporalAccessor);
//
//		//方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss E”)
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		// 格式化：DateTime ---->文本
		String dateTimeStr = dateTimeFormatter2.format(localDateTime);
		System.out.println(dateTimeStr);// 2017-08-15 05:07:33
		// 解析:文本 --->DateTime
		TemporalAccessor temporalAccessor1 = dateTimeFormatter2.parse("2017-08-15 05:07:33");
		System.out.println(temporalAccessor1);

	}

}
