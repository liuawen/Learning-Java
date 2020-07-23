package com.awen.test02.abstract_;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 *
 * 面向对象的基本特性 封装、继承、多态
 * 面向对象的特征：封装、继承、多态、抽象
 *
 * abstract
 * 抽象：
 *      是具体的反义词
 *      和模糊、不确定，不清晰有的类似
 * 1、什么情况下会用到抽象？
 * 当我们在声明一个类时，某个/些方法的实现不清楚，或者说
 * 部分给出具体的实现，要等到具体的子类中才能给出具体实现
 * 这样的方法就可以声明为抽象方法
 *
 * 例如：我们声明一个图形类：Graphic
 * 我们知道在图形这个事物中 不管是什么图形，都有两个特征：
 * （1）求面积
 * （2）求周长
 *
 * 抽象类的特点
 *
 */
public class TestAbstract {
    public static void main(String[] args) {
        double d = 2.0;
        int i = 2;
        int j = 2;
        String str = "2";
        System.out.println(i == j);//true
        System.out.println(i == d);//true

        //编译出错  编译都过不了
//        System.out.println(str == i);//Operator '==' cannot be applied to 'java.lang.String', 'int'
//        System.out.println(str == d);//Operator '==' cannot be applied to 'java.lang.String', 'double'
    }
}
abstract class Graphic{
    public abstract double getArea();
}