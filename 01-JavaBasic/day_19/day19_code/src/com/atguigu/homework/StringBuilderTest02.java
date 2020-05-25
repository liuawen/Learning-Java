package com.atguigu.homework;

import java.io.IOException;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-25
 */
public class StringBuilderTest02 {
    public static void main(String[] args) throws IOException {
        //定义数字字符串数组
        String[] str = {"010", "3223", "666", "7890987", "123123"};
        SBTest(str);
        //Result
        //010是对称的
        //3223是对称的
        //666是对称的
        //7890987是对称的
        //总数为4
    }

    public static void SBTest(String[] str) {
        int count = 0;
        //遍历定义的字符串数组
        for (String string : str) {
            //创建StringBuilder对象
            StringBuilder sb = new StringBuilder(string);
            //调用reverse()方法，将遍历的数字进行反转，然后用equals()方法对比是否与原数字相同
            if (sb.reverse().toString().equals(string)) {
                count++;
                System.out.println(string + "是对称的");
            }
        }
        System.out.println("总数为" + count);
    }
}
