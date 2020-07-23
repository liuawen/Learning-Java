package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-21
 * @describe : 定义 Circle 类
 */
public class Circle extends Shape {

    protected double radius;


    public Circle() {
        // 可以在这里完成对 type 的初始化
        this.type = "圆";
    }

    public void calculate() {
        // 在这里计算圆的面积，并将面积存储到 area 变量中 ( area 是从父类继承的、可见的实例变量 )
        area = Math.pow(radius, 2) * Math.PI;
    }

    public void description() {
        // 在这里输出圆基本信息(比如圆的半径)
        // 最后通过调用从父类继承的、可见的 show 方法输出 三角形的面积
        System.out.println("Circle的半径{" +
                "radius=" + radius +
                '}');
        super.show();
    }

}
