package test02;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
方法的参数传递机制：
	实参-->形参

（1）形参是基本数据类型
	实参赋值给形参的是数据值，形参值的修改不影响实参，因为实参是“copy，复制”了一份数据值给形参
（2）形参是引用数据类型
	实参赋值给形参的是对象的地址值，如果形参修改了对象的属性值，那么实参对象的属性值也会修改。

	给对象的地址值 改变的  找到改变
*/
class Test02_PassParamValue_2{
    public static void main(String[] args){
        Circle yuan = new Circle();
        yuan.radius = 1.0;

        doubleRadius(yuan);

        System.out.println("半径：" + yuan.radius);
    }
    //方法的功能：可以把c这个圆对象的半径，变为原来的2倍
    public static void doubleRadius(Circle c){
        c.radius *= 2;
    }
    //搞两倍的  可以改变  引用类型
}
class Circle{
    double radius;
}