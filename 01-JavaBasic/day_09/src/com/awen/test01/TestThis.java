package com.awen.test01;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */

/**
 * this:
 * 1、意思 当前对象
 * （1）构造器
 * 正在被创建的对象
 * （2）方法
 * 正在调用该方法的对象
 * 2、用法
 * （1）this.属性
 * 为什么加this呢  当局部变量与成员变量同名时，可以在成员变量的前面加this。
 * （2）this.方法
 * this.getArea() getArea();
 * （3）this() 无参构造  this(实参列表)
 * 必须在构造器的首行
 */
public class TestThis {
}

class Circle {
    private double radius;

    public Circle() {

    }

    //见名知意
   /* public Circle(double r){
        this.radius = r;
    }*/
    //double radius 局部变量
    //
    public Circle(double radius) {
        this.radius = radius;
    }
}