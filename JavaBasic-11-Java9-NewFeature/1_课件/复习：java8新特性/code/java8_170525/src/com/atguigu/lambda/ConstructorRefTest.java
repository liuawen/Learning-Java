package com.atguigu.lambda;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * 1.格式： 类名 :: new
 * 2.要求：函数式接口中抽象方法的形参列表与构造器形参列表一致（类型相同，个数相同），
 *        同时，抽象方法的返回值类型即为构造器所属的类的类型。
 *
 *
 * 二、数组引用
 *
 *
 * Created by shkstart on 2017/8/29 0029.
 */
public class ConstructorRefTest {

    @Test
    public void test4(){
        Function<Integer,String[]> func1 = (length) -> new String[length];
        String[] arr = func1.apply(10);
        System.out.println(arr.length);

        System.out.println("**********");
        
        Function<Integer,String[]> func12 = String[] ::new;
        
    }

    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> func1 = (id,name) -> new Employee(id,name);
        Employee emp = func1.apply(10, "Jim");
        System.out.println(emp);

        System.out.println("**********");

        BiFunction<Integer,String,Employee> func2 =  Employee ::new;
    }

    @Test
    public void test2(){
        Function<Integer,Employee> func1 = (id) -> new Employee(id);
        Employee emp1 = func1.apply(12);
        System.out.println(emp1);

        System.out.println("**********");

        Function<Integer,Employee> func2 = Employee::new;
    }

    @Test
    public void test1(){
        Supplier<Employee> sup = () -> new Employee();
        Employee emp = sup.get();
        System.out.println(emp);

        System.out.println("**********");

        Supplier<Employee> sup1 = Employee :: new;
    }
}
