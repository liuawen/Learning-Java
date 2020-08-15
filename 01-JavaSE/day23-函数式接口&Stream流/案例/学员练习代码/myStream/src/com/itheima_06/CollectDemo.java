package com.itheima_06;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Stream流的收集方法
        R collect​(Collector collector)

    它是通过工具类Collectors提供了具体的收集方式
        public static <T> Collector toList​()：把元素收集到List集合中
        public static <T> Collector toSet​()：把元素收集到Set集合中
        public static Collector toMap​(Function keyMapper,Function valueMapper)：把元素收集到Map集合中
 */
public class CollectDemo {
    public static void main(String[] args) {
        //创建List集合对象
        List<String> list = new ArrayList<String>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");

        //需求1：得到名字为3个字的流


        //需求2：把使用Stream流操作完毕的数据收集到List集合中并遍历


        //创建Set集合对象
        Set<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(33);
        set.add(35);

  
        //需求3：得到年龄大于25的流


        //需求4：把使用Stream流操作完毕的数据收集到Set集合中并遍历
 


        //定义一个字符串数组，每一个字符串数据由姓名数据和年龄数据组合而成
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33", "柳岩,25"};

        //需求5：得到字符串中年龄数据大于28的流


        //需求6：把使用Stream流操作完毕的数据收集到Map集合中并遍历，字符串中的姓名作键，年龄作值
        
    }
}
