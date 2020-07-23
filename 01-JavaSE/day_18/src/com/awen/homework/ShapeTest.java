package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-23
 * @describe :
 */
public class ShapeTest {
    public static void main(String[] args) {
        Trapezoid t = new Trapezoid(30, 40, 50); // 创建 Trapezoid 实例
        t.calculate(); // 计算梯形面积
        t.show(); // 输出梯形信息和梯形面积

        Sector s = new Sector(5, 5);
        s.calculate(); // 计算扇形面积
        s.show(); // 输出扇形信息和扇形面积

        //Result
        //计算梯形的面积
        //Trapezoid的基本信息{top=30.0, bottom=40.0, height=50.0'}
        //梯形的面积为35.0
        //计算扇形的面积
        //Sector的基本信息{radius=5.0, arcLength=5.0}
        //扇形的面积为12.5
    }
}
