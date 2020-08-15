package com.itheima_02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    工具类

    构造方法私有
    成员方法静态
 */
public class DateUtils {
    private DateUtils() {}

    /*
        把日期转为指定格式的字符串
        返回值类型：String
        参数：Date date, String format
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(date);
        return s;
    }


    /*
        把字符串解析为指定格式的日期
        返回值类型：Date
        参数：String s, String format
     */
    public static Date stringToDate(String s, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = sdf.parse(s);
        return d;
    }

}
