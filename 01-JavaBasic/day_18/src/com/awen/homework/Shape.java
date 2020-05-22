package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-22
 * @describe : 定义 Shape 类,充当各种图形类的父类
 */
public class Shape {
    protected double area; // 为了让子类能够访问 area 变量，这里修饰符为 protected
    private String type; // 创建子类对象时通过调用父类构造方法设置图形种类

    public Shape(String type) {
        this.type = type;
    }

    public void calculate() {
        System.out.println("计算" + this.type + "的面积");
        // 父类 Shape 的 calculate 中仅仅包含一条输出语句，没有任何计算过程
    }

    public void show() {
        // 在 Shape 类中 show 方法除了输出语句外，没有任何其它代码
        System.out.println(this.type + "的面积为" + this.area);
    }
}
