package cn.liuawen.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-29
 */
public class Test5 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = format.parse("2020-05-29");
            System.out.println("程序正常");
            System.out.println(date);
            //Wed Jan 29 00:05:00 CST 2020
        } catch (ParseException e) {
            System.out.println("程序异常");
        }
        //程序正常
    }
}
