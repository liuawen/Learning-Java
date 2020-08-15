package com.itheima_01;

import java.util.HashSet;
import java.util.Set;

/*
    Set集合特点
        不包含重复元素的集合
        没有带索引的方法，所以不能使用普通for循环遍历

    HashSet:对集合的迭代顺序不作任何保证
 */
public class SetDemo {
    public static void main(String[] args) {
        //创建集合对象
        Set<String> set = new HashSet<String>();

        //添加元素
        set.add("hello");
        set.add("world");
        set.add("java");
        //不包含重复元素的集合
        set.add("world");

        //遍历
        for(String s : set) {
            System.out.println(s);
        }

    }
}
