package com.itheima_05;
/*
    遍历
        获取数组中的每一个元素输出在控制台

    获取数组元素
        数组名.length
 */
public class ArrayTest01 {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {11, 22, 33, 44, 55};

        //使用通用的遍历格式
        for(int x=0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
    }
}
