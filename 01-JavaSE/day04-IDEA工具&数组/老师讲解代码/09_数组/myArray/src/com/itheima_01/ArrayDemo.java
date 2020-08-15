package com.itheima_01;
/*
    数组：是一种用于存储多个相同类型数据的存储模型

    定义格式：(推荐方式)
        数据类型[] 数组名;
        举例：int[] arr;

    数组初始化：
        A:所谓初始化：就是为数组中的数组元素分配内存空间，并为每个数组元素赋值
        B:数组初始化
            动态初始化
            静态初始化

    动态初始化：
        初始化时只指定数组长度，由系统为数组分配初始值
        格式：数据类型[] 变量名 =  new  数据类型[数组长度];
        范例：int[] arr = new int[3];
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[3];
        /*
            左边：
                int:说明数组中的元素类型是int类型
                []:说明这是一个数组
                arr:这是数组的名称
            右边：
                new:为数组申请内存空间
                int:说明数组中的元素类型是int类型
                []:说明这是一个数组
                3:数组长度，其实就是数组中的元素个数
         */

        //输出数组名
        System.out.println(arr); //[I@880ec60

        //输出数组中的元素
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
