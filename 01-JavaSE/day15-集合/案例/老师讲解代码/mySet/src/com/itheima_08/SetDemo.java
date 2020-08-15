package com.itheima_08;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
    需求：
        编写一个程序，获取10个1-20之间的随机数，要求随机数不能重复，并在控制台输出

    思路：
        1:创建Set集合对象
        2:创建随机数对象
        3:判断集合的长度是不是小于10
            是：产生一个随机数，添加到集合
            回到3继续
        4:遍历集合
 */
public class SetDemo {
    public static void main(String[] args) {
        //创建Set集合对象
//        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set = new TreeSet<Integer>();

        //创建随机数对象
        Random r = new Random();

        //判断集合的长度是不是小于10
        while (set.size()<10) {
            //产生一个随机数，添加到集合
            int number = r.nextInt(20) + 1;
            set.add(number);
        }

        //遍历集合
        for(Integer i : set) {
            System.out.println(i);
        }
    }
}
