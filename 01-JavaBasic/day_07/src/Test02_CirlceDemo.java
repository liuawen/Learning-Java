
/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明一个圆的图形类，有属性：半径
2、在测试类的main中，创建圆的2个对象，并为半径属性赋值
*/
//练习   类的声明   有属性 半径
class Test02_CirlceDemo{
    public static void main(String[] args){
        //1、创建第一个圆对象
        //类名 对象名 = new 类名();
        //Circle c1;//声明一个引用数据类型的变量,用来存储一个圆对象
        //c1 = new Circle();//为c1变量赋值一个圆对象

        //把两步合成一步
        Circle c1 = new Circle();

        //2、为第一个圆对象的半径赋值
        c1.radius = 2.5;

        //3、显示第一个圆对象的半径值
        System.out.println("第一个圆的半径：" + c1.radius);

        //4、创建第二个圆对象
        Circle c2 = new Circle();
        c2.radius = 1.2;
        System.out.println("第二个圆的半径：" + c2.radius);

    }
}