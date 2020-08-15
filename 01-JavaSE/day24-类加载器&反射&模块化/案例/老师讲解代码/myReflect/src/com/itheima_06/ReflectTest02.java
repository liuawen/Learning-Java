package com.itheima_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    练习2：通过配置文件运行类中的方法
 */
public class ReflectTest02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Student s = new Student();
//        s.study();

//        Teacher t = new Teacher();
//        t.teach();

        /*
            class.txt
            className=xxx
            methodName=xxx
         */

        //加载数据
        Properties prop = new Properties();
        FileReader fr = new FileReader("myReflect\\class.txt");
        prop.load(fr);
        fr.close();

        /*
            className=com.itheima_06.Student
            methodName=study
         */
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //通过反射来使用
        Class<?> c = Class.forName(className);//com.itheima_06.Student

        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        Method m = c.getMethod(methodName);//study
        m.invoke(obj);
    }
}
