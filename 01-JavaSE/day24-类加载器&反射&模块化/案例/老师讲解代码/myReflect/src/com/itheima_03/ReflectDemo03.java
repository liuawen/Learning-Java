package com.itheima_03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    通过反射实现如下的操作：
        Student s = new Student("林青霞");
        System.out.println(s);
 */
public class ReflectDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class<?> c = Class.forName("com.itheima_02.Student");

        //private Student(String name)
        //Constructor<T> getDeclaredConstructor​(Class<?>... parameterTypes)
        Constructor<?> con = c.getDeclaredConstructor(String.class);

        //暴力反射
        //public void setAccessible​(boolean flag):值为true，取消访问检查
        con.setAccessible(true);

        Object obj = con.newInstance("林青霞");
        System.out.println(obj);

    }
}
