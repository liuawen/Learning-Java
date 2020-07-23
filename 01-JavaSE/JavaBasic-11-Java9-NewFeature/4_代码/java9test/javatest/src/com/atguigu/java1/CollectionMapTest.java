package com.atguigu.java1;

import org.junit.Test;

import java.util.*;

/**
 * Created by songhongkang on 2017/12/29 0029.
 */
public class CollectionMapTest {


    //jdk 8 以及之前：创建一个只读特点的集合
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Lilei");
        list.add("HanMeimei");

        //调用Collections中的方法，将list变为只读的
        List<String> newList = Collections.unmodifiableList(list);

//        newList.add("Tim");//不能执行，否则报异常

        //遍历：jdk 8
        newList.forEach(System.out::println);

    }

    //jdk 8 以及之前：创建一个只读特点的集合
    @Test
    public void test2(){
        //List:
        List<Integer> list = Collections.unmodifiableList(Arrays.asList(1, 2, 3));

//        list.add(4);

        //Set:
        Set<Integer> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3)));

//        set.add(4);

//        set.forEach(System.out::println);

        //Map:
        Map<Object, Object> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("Tom", 78);
                put("Jerry", 88);
                put("Tim", 68);
            }
        });

        map.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    //jdk 9 中：创建一个只读特点的集合
    @Test
    public void test3(){
        //List:
        List<Integer> list = List.of(1, 2, 3);

//        list.add(4);

        list.forEach(System.out::println);

        //Set:
        Set<Integer> set = Set.of(2, 3, 4);

//        set.add(6);

        //Map:
        //创建只读集合的方式一：
        Map<String, Integer> map = Map.of("Tom", 23, "Jerry", 22, "Lilei", 12, "HanMeimei", 18);

//        map.put("Tim",33);

        //创建只读集合的方式二：
        Map<String, Integer> map1 = Map.ofEntries(Map.entry("Tom", 23), Map.entry("Jerry", 21));

//        map1.put("Tim",33);

        System.out.println(map1);

    }


}
