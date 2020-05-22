package com.awen.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-21
 * @describe : 测试程序
 */
public class ShapeTest {
    public static void main(String[] args) {
        Triangle t = new Triangle(); // 创建 Triangle 实例
        t.firstEdge = 30; // 设置边长
        t.secondEdge = 40; // 设置边长
        t.thirdEdge = 50; // 设置边长
        t.calculate(); // 计算三角形面积
        t.description(); // 输出三角形信息和三角形面积
        //Triangle的三边{firstEdge=30.0, secondEdge=40.0, thirdEdge=50.0}
        //三角形的面积为600.0


        Circle c = new Circle();
        c.radius = 8; // 设置半径
        c.calculate(); // 计算圆面积
        c.description(); // 输出圆半径和圆面积
        //Circle的半径{radius=8.0}
        //圆的面积为201.06192982974676
    }
}
