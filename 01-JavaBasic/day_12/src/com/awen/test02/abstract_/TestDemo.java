package com.awen.test02.abstract_;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 */
public class TestDemo {
    public static void main(String[] args) {
        double d = 2.0;
        int i = 2;
        int j = 2;
        String str = "2";
        System.out.println(i == j);//true
        System.out.println(i == d);//true

        //编译出错  编译都过不了
//        System.out.println(str == i);//Operator '==' cannot be applied to 'java.lang.String', 'int'
//        System.out.println(str == d);//Operator '==' cannot be applied to 'java.lang.String', 'double'
    }
}
