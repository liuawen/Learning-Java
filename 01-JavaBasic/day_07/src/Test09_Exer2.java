/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明一个矩形类，有属性：长、宽
2、在矩形类中，声明两个方法：
（1）返回矩形面积
（2）返回矩形周长
3、在测试类中测试
*/
class Rectangle{
    //属性：长、宽
    double length;
    double width;

    //（1）返回矩形面积
    double getArea(){
        return length * width;
    }

    //（2）返回矩形周长
    double getPerimeter(){
        return (length + width)*2;
    }

    void printInfo(){
        System.out.println("长：" + length + "，宽：" +width + "，面积：" + getArea() + "，周长：" + getPerimeter());
    }
}
class Test09_Exer2{
    public static void main(String[] args){
        //1、创建对象
        Rectangle r = new Rectangle();

        //2、为属性赋值
        r.length = 3;
        r.width = 5;

        //3、获取面积和周长
        System.out.println("面积：" + r.getArea());
        System.out.println("周长：" + r.getPerimeter());

        //4、打印详细信息
        r.printInfo();
    }
}