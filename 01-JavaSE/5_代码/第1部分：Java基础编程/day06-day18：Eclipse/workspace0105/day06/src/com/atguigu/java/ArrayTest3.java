package com.atguigu.java;
/*
 * 二维数组的使用：
 * 	规定：二维数组分为外层数组的元素，内层数组的元素
 * 		int[][] arr = new int[4][3];
 * 		外层元素：arr[0],arr[1]等
 * 		内层元素：arr[0][0],arr[1][2]等
 * 
 *   ⑤ 数组元素的默认初始化值 
 *   针对于初始化方式一：比如：int[][] arr = new int[4][3];
 *      外层元素的初始化值为：地址值
 *      内层元素的初始化值为：与一维数组初始化情况相同
 *      
 *   针对于初始化方式二：比如：int[][] arr = new int[4][];
 *   	外层元素的初始化值为：null
 *      内层元素的初始化值为：不能调用，否则报错。
 *   
 *   ⑥ 数组的内存解析 
 * 
 */
public class ArrayTest3 {
	public static void main(String[] args) {
		
		int[][] arr = new int[4][3];
		System.out.println(arr[0]);//[I@15db9742 
		System.out.println(arr[0][0]);//0
		
//		System.out.println(arr);//[[I@6d06d69c
		
		System.out.println("*****************");
		float[][] arr1 = new float[4][3];
		System.out.println(arr1[0]);//地址值
		System.out.println(arr1[0][0]);//0.0
		
		System.out.println("*****************");
		
		String[][] arr2 = new String[4][2];
		System.out.println(arr2[1]);//地址值
		System.out.println(arr2[1][1]);//null
		
		System.out.println("*****************");
		double[][] arr3 = new double[4][];
		System.out.println(arr3[1]);//null
//		System.out.println(arr3[1][0]);//报错
		
	}
}
