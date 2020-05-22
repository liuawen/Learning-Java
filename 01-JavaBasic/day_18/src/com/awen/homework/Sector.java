package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-23
 * @describe : 定义 Sector 类， 求扇形面积
 */
public class Sector extends Shape {
    private double radius;
    private double arcLength;
    private double degree;


    public Sector(double radius, double arcLength) {
        super("扇形");
        this.radius = radius;
        this.arcLength = arcLength;
    }

    /*public Sector(double radius, double degree) {
        super("扇形");
        this.radius = radius;
        this.degree = degree;
    }*/
    public void calculate() {
        // 首先调用从父类中继承的、可见的 calculate 方法
        // 然后在这里计算梯形的面积，并将面积存储到 area 变量中 ( 实例变量 area 是从父类继承来的 )
        super.calculate();
        area = arcLength * radius / 2;

    }


    public void show() {
        // 先在这里输出扇形基本信息(比如 半径、弧长等信息)
        System.out.println("Sector的基本信息{" +
                "radius=" + radius +
                ", arcLength=" + arcLength +
                '}');
        // 最后通过调用父类的 show 方法输出 扇形的面积
        super.show();
    }
}
