package com.itheima_02;

/*
    try {
        可能出现异常的代码;
    } catch(异常类名 变量名) {
        异常的处理代码;
    }
 */
public class ExceptionDemo01 {
    public static void main(String[] args) {
        System.out.println("开始");
        method();
        System.out.println("结束");
    }

    public static void method() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);
            System.out.println("这里能够访问到吗");
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("你访问的数组索引不存在，请回去修改为正确的索引");
            e.printStackTrace();
        }
    }
}
