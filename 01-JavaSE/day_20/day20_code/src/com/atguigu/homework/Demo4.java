package com.atguigu.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-25
 */
public class Demo4 {
    public static void main(String[] args) {
        System.out.println(inc(10)+inc(8)+inc(-10));
    }
    public static  int inc(int temp){
        if (temp>0){
            return temp*2;
        }
        return -1;
    }
}
