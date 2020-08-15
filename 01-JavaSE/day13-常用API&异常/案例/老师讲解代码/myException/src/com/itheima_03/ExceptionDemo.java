package com.itheima_03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    throws 异常类名;
    这个格式是跟在方法的括号后面的
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("开始");
//        method();
        try {
            method2();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }

    //编译时异常
    public static void method2() throws ParseException {
        String s = "2048-08-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(s);
        System.out.println(d);
    }

    //运行时异常
    public static void method() throws ArrayIndexOutOfBoundsException {
        int[] arr = {1, 2, 3};
        System.out.println(arr[3]);
    }

}
