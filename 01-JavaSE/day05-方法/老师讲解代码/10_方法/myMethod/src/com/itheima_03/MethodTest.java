package com.itheima_03;

/*
    需求：
        设计一个方法可以获取两个数的较大值，数据来自于参数

    思路：
        1:定义一个方法，用于获取两个数字中的较大数
        2:使用分支语句分两种情况对两个数字的大小关系进行处理
        3:根据题设分别设置两种情况下对应的返回结果
        4:在main()方法中调用定义好的方法并使用变量保存
        5:在main()方法中调用定义好的方法并直接打印结果
 */
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法并使用变量保存
        int result = getMax(10,20);
        System.out.println(result);

        //在main()方法中调用定义好的方法并直接打印结果
        System.out.println(getMax(10,20));
    }

    //定义一个方法，用于获取两个数字中的较大数
    public static int getMax(int a, int b) {
        //使用分支语句分两种情况对两个数字的大小关系进行处理
        //根据题设分别设置两种情况下对应的返回结果
        if(a > b) {
            return a;
        } else {
            return b;
        }
    }
}
