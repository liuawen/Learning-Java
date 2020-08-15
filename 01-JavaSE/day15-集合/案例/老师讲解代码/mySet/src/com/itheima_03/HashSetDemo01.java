package com.itheima_03;

import java.util.HashSet;

/*
    HashSet集合特点
        1:底层数据结构是哈希表
        2:对集合的迭代顺序不作任何保证，也就是说不保证存储和取出的元素顺序一致
        3:没有带索引的方法，所以不能使用普通for循环遍历
        4:由于是Set集合，所以是不包含重复元素的集合
 */
public class HashSetDemo01 {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<String> hs = new HashSet<String>();

        //添加元素
        hs.add("hello");
        hs.add("world");
        hs.add("java");

        hs.add("world");

        //遍历
        for(String s : hs) {
            System.out.println(s);
        }
    }
}
