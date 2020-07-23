package test01;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
class Test01_Review{
    public static void main(String[] args){
        //1、创建对象：匿名对象
        System.out.println(new Circle());

        //2、创建对象：给对象命名
        Circle c = new Circle();
        System.out.println(c);
    }
}
class Circle{
    double radius;
}