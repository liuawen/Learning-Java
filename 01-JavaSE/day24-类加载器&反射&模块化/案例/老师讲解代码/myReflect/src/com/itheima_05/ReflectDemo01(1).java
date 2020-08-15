package com.itheima_05;

import com.itheima_02.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    反射获取成员方法并使用
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class<?> c = Class.forName("com.itheima_02.Student");

        //Method[] getMethods​() 返回一个包含 方法对象的数组， 方法对象反映由该 Class对象表示的类或接口的所有公共方法，包括由类或接口声明的对象以及从超类和超级接口继承的类
        //Method[] getDeclaredMethods​() 返回一个包含 方法对象的数组， 方法对象反映由 Class对象表示的类或接口的所有声明方法，包括public，protected，default（package）访问和私有方法，但不包括继承方法
//        Method[] methods = c.getMethods();
        Method[] methods = c.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method);
        }
        System.out.println("--------");

        //Method getMethod​(String name, Class<?>... parameterTypes) 返回一个 方法对象，该对象反映由该 Class对象表示的类或接口的指定公共成员方法
        //Method getDeclaredMethod​(String name, Class<?>... parameterTypes) 返回一个 方法对象，它反映此表示的类或接口的指定声明的方法 Class对象
        //public void method1()
        Method m = c.getMethod("method1");

        //获取无参构造方法创建对象
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

//        obj.m();

        //在类或接口上提供有关单一方法的信息和访问权限
        //Object invoke​(Object obj, Object... args) 在具有指定参数的指定对象上调用此 方法对象表示的基础方法
        //Object：返回值类型
        //obj：调用方法的对象
        //args：方法需要的参数
        m.invoke(obj);

//        Student s = new Student();
//        s.method1();
    }
}
