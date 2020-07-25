package com.itheima.convert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.format.Formatter;
/**
 * 使用Formatter自定义日期转换器
 */
public class DateFormatter implements Formatter<Date>{
    // 定义日期格式
	String datePattern = "yyyy-MM-dd HH:mm:ss";
	// 声明SimpleDateFormat对象
    private SimpleDateFormat simpleDateFormat;   
	@Override
	public String print(Date date, Locale locale) {
		return new SimpleDateFormat().format(date);
	}
	@Override
     public Date parse(String source, Locale locale) throws ParseException
     {
		simpleDateFormat = new SimpleDateFormat(datePattern);
		return simpleDateFormat.parse(source);
	}
}
