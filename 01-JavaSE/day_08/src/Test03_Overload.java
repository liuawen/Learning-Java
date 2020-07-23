/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
方法的重载：
	在同一个类中，出现了两个或多个的方法名称相同，形参列表不同，称为方法的重载。
	形参列表不同：形参的个数、数据类型不同
	方法的重载和返回值类型无关。

为什么要有方法的重载？或者换句话说，为什么要声明多个方法名称相同呢？
（1）方法名代表方法的功能，这几个方法的功能是一样的，例如：都是找最大值
（2）为了调用者的方便，功能相同的方法取名一样的话，对于调用者来说就减少了学习和记忆的成本
调用者 功能相同的方法取名一样的话  对于调用者来说就减少了学习和记忆的成本呢
好多方法   简化我们的使用   一个方法   当时再传递参数不同
大量方法名一样 形参不一致

*/
class Test03_Overload{
    public static void main(String[] args){
        System.out.println(max(1,4));
        System.out.println(max(1.0,4.0));
        System.out.println(max(1,4,8));
    }

    //写一个方法，可以找2个整数的最大值
    public static int max(int a, int b){
        return a>b ? a : b;
    }
    //方法重载时，不去看返回值类型是否一致，只看方法名和形参列表
    //public static double max(int a,int b){
    //	return 0.0;
    //}

    //写一个方法，可以找2给小数的最大值
    public static double max(double a, double b){
        return a>b ? a : b;
    }

    //写一个方法，可以找3个整数的最大值
    public static int max(int a, int b, int c){
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }
}