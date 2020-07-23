package com.awen.test08;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Java中把注解是看成接口。
 * Java中把枚举看成类。
 *
 * 注解的三个完整步骤：
 * （1）声明
 * （2）使用
 * （3）读取
 *
 * 一、注解的声明
 * 语法格式：
 * 	【修饰符】 @interface 注解名{
 * 	}
 *
 * 二、元注解
 * 元注解：注解注解的注解，或者换句话说，加在注解上面的注解，叫做元注解
 * 1、@Target
 * 标记这个注解可以用于什么位置。
 * 它由ElementType枚举的常量对象来决定：
 * 	 例如：TYPE,FIELD,CONSTRUCTOR等10个位置
 *
 * 2、@Retention
 * 标记这个注解可以滞留到什么阶段
 * 它由RetentionPolicy的3个常量对象来指定：
 * 		SOURCE, CLASS, RUNTIME
 * SOURCE：源代码阶段.java		只能被编译器读取
 * CLASS：字节码阶段.class
 * RUNTIME：运行时JVM
 *
 * 3、@Documented
 * 标记某个注解是否可以被javadoc.exe读取到API
 *
 * 4、@Inherited
 * 标记这个注解是否可以被子类继承
 */
public class TestDefineAnnotation {
    public static void main(String[] args) {
        //以下这段代码是用到了反射的内容，今天暂时不用看懂，知道是读取
        Class clazz = MyClass.class;
        MyAnnotation my = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        System.out.println(my);
    }
}
//使用注解
@MyAnnotation
class MyClass{

}

class Sub extends MyClass{

}

//自定义注解
//@Target(ElementType.METHOD)//这个表示只能用在方法上
@Target({ElementType.METHOD,ElementType.TYPE})//这个表示可以用在方法和类型上面
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotation{

}