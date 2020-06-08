package com.atguigu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.atguigu.lambda.Employee;
import com.atguigu.lambda.EmployeeData;

/**
 * 测试中间操作
 * 1.可以通过Stream的实例，执行多次中间操作
 * 2.中间操作，只有在执行了终止操作以后才会执行。
 *
 *
 *
 * Created by shkstart on 2017/8/29 0029.
 */
public class StreamAPITest1 {

    //3-排序
    @Test
    public void test4(){
//        sorted()——自然排序
        List<Integer> list = Arrays.asList(23,43,454,32,1,2,5,5,-8);
        list.stream().sorted().forEach(System.out::println);

        //此时针对Employees进行排序：失败。原因：Employee类没有实现Comparable接口
//        List<Employee> list1 = EmployeeData.getEmployees();
//        list1.stream().sorted().forEach(System.out::println);

//        sorted(Comparator com)——定制排序
        List<Employee> list1 = EmployeeData.getEmployees();
       
        
        list1.stream().sorted((e1,e2) -> {
            if(e1.getAge() != e2.getAge()){
                return e1.getAge() - e2.getAge();
            }else{
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);

    }

    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
//        System.out.println(list1);//[1, 2, 3, [4, 5, 6]]

//        list1.addAll(list2);
//        System.out.println(list1);//[1, 2, 3, 4, 5, 6]

    }
    //2-映射
    @Test
    public void test2(){
//        map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
//        练习：获取员工姓名长度大于3的员工的姓名。
        Stream<Employee> stream = EmployeeData.getEmployees().stream();
        Stream<String> stream1 = stream.map(Employee::getName);
        stream1.filter(name -> name.length() > 3).forEach(System.out::println);


        Stream<Stream<Character>> stream2 = list.stream().map(StreamAPITest1 :: fromStringToChar);
        stream2.forEach(
        		x -> {
        			x.forEach(System.out::println);
        		}
        		);

        System.out.println();

//        flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> stream3 = list.stream().flatMap(StreamAPITest1::fromStringToChar);
        stream3.forEach(System.out::println);
    }
    //将str中的字符存在集合中，返回集合的Stream
    public static Stream<Character> fromStringToChar(String str){
        ArrayList<Character> list = new ArrayList<>();
//        for(Character c : str.toCharArray()){
//              list.add(c);
//        }
        for(int i = 0;i < str.length();i++){
            list.add(str.charAt(i));
        }
        return list.stream();
    }


    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
//        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = list.stream().filter(e -> e.getAge() > 30);
        stream.forEach(System.out::println);

        System.out.println();

//        limit(n)——截断流，使其元素不超过给定数量。
        list.stream().filter(e -> e.getAge() > 30).limit(3).forEach(System.out::println);

        System.out.println();

        //skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().filter(e -> e.getAge() > 30).skip(3).forEach(System.out::println);

        System.out.println();

        //distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1009,"刘强东",30,6000));
        list.add(new Employee(1009,"刘强东",30,6000));
        list.add(new Employee(1009,"刘强东",30,6000));
        list.add(new Employee(1009,"刘强东",30,6000));
        list.add(new Employee(1009,"刘强东",30,6000));
        list.stream().distinct().forEach(System.out::println);
        
    }
}
