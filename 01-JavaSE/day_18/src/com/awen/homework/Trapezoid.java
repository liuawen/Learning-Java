package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-23
 * @describe : 定义一个Trapezoid类，求梯形面积
 */
public class Trapezoid extends Shape {
    private double top;
    private double bottom;
    private double height;

    public Trapezoid(double top, double bottom, double height) {
        super("梯形");
        this.top = top;
        this.bottom = bottom;
        this.height = height;
    }

    public Trapezoid(String type) {
        // 直接在 Trapezoid 类中书写无参构造是无法编译的，你需要解决这个编译错误
        super(type);
    }

    public void calculate() {
        // 首先调用从父类中继承的、可见的 calculate 方法
        // 然后在这里计算梯形的面积，并将面积存储到 area 变量中 ( 实例变量 area 是从父类继承来的 )
        super.calculate();
        area = (top + bottom) / 2;

    }

    public void show() {
        // 先在这里输出梯形基本信息(比如 上底、下底、高 等信息)
        System.out.println("Trapezoid的基本信息{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", height=" + height +
                "'}");
        // 最后通过调用父类的 show 方法输出 梯形的面积
        super.show();
    }

}
