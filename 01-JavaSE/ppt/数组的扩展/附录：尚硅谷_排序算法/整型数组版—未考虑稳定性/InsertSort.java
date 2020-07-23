package com.atguigu.java.sort;

/**
 * 直接插入排序
 * 
 * @author shkstart 2013-11-27
 */
public class InsertSort {
	public static void insertSort(int[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		for (int i = 1; i < arrayLength; i++) {
			int temp = data[i];
			if (data[i] - data[i - 1] < 0) {
				int j = i - 1;
				for (; j >= 0 && data[j] - temp > 0; j--) {
					data[j + 1] = data[j];
				}
				data[j + 1] = temp;
			}
			System.out.println(java.util.Arrays.toString(data));
		}

	}

	public static void main(String[] args) {
		int[] data = { 9, -16, 21, 23, -30, -49, 21, 30, 30 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		insertSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
