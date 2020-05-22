package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-21
 * @describe : 定义一个 名称为 Shape 的类，充当各种图形类的父类
 */
public class Shape {
    protected double area; // 为了让子类能够访问 area 变量，这里修饰符为 protected
    protected String type; // 为了让子类能够访问 area 变量，这里修饰符为 protected

    public void show() {
        // 在 Shape 类中 show 方法除了输出语句外，没有任何其它代码
        System.out.println(this.type + "的面积为" + this.area);
    }
}
