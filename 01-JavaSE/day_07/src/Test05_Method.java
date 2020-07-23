/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
类的成员之二：方法
	方法(method)又称为函数(function)。
	方法是代表一个独立的可复用的功能。
例如：Math.random()，代表产生[0,1)随机值的功能
      Math.sqrt(x)，代表求x的平方根的功能

声明方法的好处：
（1）代码的复用
（2）简化程序员的代码量：使用者不管关心方法的内部如何实现的，
只要关注这个方法：功能、是否需要传参数、是否有返回值等问题

1、如何声明一个方法？
【修饰符】 返回值类型  方法名(【形参列表】){
	方法体：实现代码的功能
}

【修饰符】：今天先不讨论
返回值类型：
（1）void：代表无返回值，
（2）非void：可以是任意的Java数据类型，包括8种基本数据类型、所有的引用数据类型
方法名：
（1）见名知意：能够体现这个方法的功能
见名知意
（2）和变量名一样，从第二个单词开始首字母大写
(【形参列表】)：
（1）()：无参
（2）(形参列表)：有参


*/
class Test05_Method{
    /*
    public static：修饰符
    void：返回值类型
    main；方法名
    (String[] args)：形参列表
    */
    public static void main(String[] args){
        //在本类中，同一级别的方法中，调用，直接调用
        //main()与printRectangle()在同一个类中，并且是同一个级别的方法
        printRectangle();
        System.out.println("--------------------");
        printRectangle();
        //同一级别的方法中 调用   直接调用的  非常
        System.out.println("xxx");

    }

    //这个位置是在类中
    //public static 是修饰符，先照抄
    //假设我这里想要完成一个功能：打印5行10列的*组成的矩形
    //void：返回值类型，它是一种特殊的返回值类型，表示无返回值
    //printRectangle：方法名
    //()：形参列表，如果()中没有东西，称为“无参,空参”
    //{}：{}中是方法体，完成方法功能的代码
    public static void printRectangle(){
        for(int i=1; i<=5; i++){
            for(int j=1; j<=10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}