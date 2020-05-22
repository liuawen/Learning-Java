package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-21
 * @describe : 定义 Triangle 类
 */
public class Triangle extends Shape {
    protected double firstEdge;
    protected double secondEdge;
    protected double thirdEdge;

    public Triangle() {
        // 可以在这里完成对 type 的初始化
        this.type = "三角形";
    }

    public void calculate() {
        // 在这里计算三角形的面积，并将面积存储到 area 变量中 ( area 是从父类继承的、可见的实例变量 )
        double p = (firstEdge + secondEdge + thirdEdge);
        p = p / 2;
        area = Math.sqrt(p * (p - firstEdge) * (p - secondEdge) * (p - thirdEdge));
    }

    public void description() {
        // 在这里输出三角形基本信息(比如三边的长度)
        // 最后通过调用从父类继承的、可见的 show 方法输出 三角形的面积
        System.out.println("Triangle的三边{" +
                "firstEdge=" + firstEdge +
                ", secondEdge=" + secondEdge +
                ", thirdEdge=" + thirdEdge +
                '}');
        super.show();
    }


}
