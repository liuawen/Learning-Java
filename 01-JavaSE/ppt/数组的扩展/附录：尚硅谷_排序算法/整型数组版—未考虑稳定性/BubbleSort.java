package com.atguigu.java.sort;

/**
 * 冒泡排序
 * @author shkstart
 * 2013-11-27
 */
public class BubbleSort {
	public static void bubbleSort(int[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				if(data[j] > data[j + 1]){
					int temp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = temp;
					flag = true;
				}
			}
			System.out.println(java.util.Arrays.toString(data));
			if (!flag)
				break;
		}
	}

	public static void main(String[] args) {
		int[] data = { 9, -16, 21, 23, -30, -49, 21, 30, 30 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		bubbleSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
