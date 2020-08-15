package com.itheima_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    需求：
        我有一个集合：List<String> list = new ArrayList<String>();
        里面有三个元素：list.add("hello");list.add("world");list.add("java");
        遍历集合，得到每一个元素，看有没有"world"这个元素，如果有，我就添加一个"javaee"元素，请写代码实现

    ConcurrentModificationException:当不允许这样的修改时，可以通过检测到对象的并发修改的方法来抛出此异常
 */
public class ListDemo {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();

        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

        //遍历集合，得到每一个元素，看有没有"world"这个元素，如果有，我就添加一个"javaee"元素，请写代码实现
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String s = it.next();
//            if(s.equals("world")) {
//                list.add("javaee");
//            }
//        }

        for(int i=0; i<list.size(); i++) {
            String s = list.get(i);
            if(s.equals("world")) {
                list.add("javaee");
            }
        }

        //输出集合对象
        System.out.println(list);
    }
}
