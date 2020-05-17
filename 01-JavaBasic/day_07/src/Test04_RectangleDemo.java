/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明一个矩形（长方形）类，有属性：长、宽
2、在测试类的main中，创建两个矩形对象，并为属性赋值
3、画出内存图
*/

class Test04_RectangleDemo{
    public static void main(String[] args){
        //1、创建第一个矩形对象
        Rectangle r1 = new Rectangle();
        //为第一个矩形对象的属性赋值
        r1.length = 1;// int  double 自动类型提升
        r1.width = 3;
        //显示第一个矩形对象的信息
        System.out.println("矩形1的长：" + r1.length + "，宽：" + r1.width);

        //1、创建第二个矩形对象
        Rectangle r2 = new Rectangle();
        //为第二个矩形对象的属性赋值
        r2.length = 4;
        r2.width = 5;
        //显示第二个矩形对象的信息
        System.out.println("矩形2的长：" + r2.length + "，宽：" + r2.width);
    }
}