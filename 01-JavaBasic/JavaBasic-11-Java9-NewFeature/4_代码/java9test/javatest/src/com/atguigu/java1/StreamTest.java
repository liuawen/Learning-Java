package com.atguigu.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by songhongkang on 2017/12/29 0029.
 */
public class StreamTest {

    //jdk 9 中针对于Stream 新添加了4个方法

    //1.takeWhile()
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(45,56,33,77,44,98,76,78,33);

        Stream<Integer> stream = list.stream();

        stream.takeWhile(x -> x < 70).forEach(System.out::println);

        System.out.println();

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
        list1.stream().takeWhile(x -> x < 5).forEach(System.out::println);
    }

    //2.dropWhile():与 takeWhile() 整好相反
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(45,56,33,77,44,98,76,78,33);

        Stream<Integer> stream = list.stream();

        stream.dropWhile(x -> x < 70).forEach(System.out::println);

        System.out.println();

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
        list1.stream().dropWhile(x -> x < 5).forEach(System.out::println);
    }

    //3.ofNullable(T t): t可以为null
    @Test
    public void test3(){

        Stream<Integer> stream1 = Stream.of(1, 2, 3, null);
        stream1.forEach(System.out::println);

        System.out.println();

        //如果只有单个元素，此元素不能为null.否则报NullPointerException
//        Stream<Object> stream2 = Stream.of(null);

        //jdk 9 :新增ofNullable(T t):
        Stream<String> stream3 = Stream.ofNullable("Tom");
        System.out.println(stream3.count());//1

        Stream<String> stream4 = Stream.ofNullable(null);
        System.out.println(stream4.count());//0

    }

    //4.iterator()重载的方法
    @Test
    public void test4(){
        //复习：Stream的实例化：①通过集合的stream() ②通过数组工具类：Arrays ③ Stream中静态方法：of() ④iterator() / generate()

        Stream.iterate(0,x -> x + 1).limit(10).forEach(System.out::println);

        System.out.println();

        Stream.iterate(0,x -> x < 10,x -> x + 1).forEach(System.out::println);
    }
}
