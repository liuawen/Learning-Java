/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明一个数学工具类，包含方法：
（1）可以求任意两个整数的和
（2）可以求任意两个整数的差
（3）可以求任意两个整数的积
（4）可以求任意两个整数的商
（5）可以打印任意两个整数的：和，差，积，商
*/
class Test13_Exer4{
    public static void main(String[] args){
        //1、创建对象
        MathTools tools = new MathTools();

        //2、调用printInfo
        tools.printInfo(4,5);
    }
}
class MathTools{
    //（1）可以求任意两个整数的和
    int sum(int a, int b){
        return a+b;
    }
    //（2）可以求任意两个整数的差
    int subtract(int a, int b){
        return a-b;
    }
    //（3）可以求任意两个整数的积
    int multiply(int a, int b){
        return a*b;
    }
    //（4）可以求任意两个整数的商
    int divide(int a, int b){
        return a/b;
    }
    //（5）可以打印任意两个整数的：和，差，积，商
    void printInfo(int a, int b){
        System.out.println(a + "+" + b + "=" + sum(a,b));
        System.out.println(a + "-" + b + "=" + subtract(a,b));
        System.out.println(a + "*" + b + "=" + multiply(a,b));
        System.out.println(a + "/" + b + "=" + divide(a,b));
    }
}