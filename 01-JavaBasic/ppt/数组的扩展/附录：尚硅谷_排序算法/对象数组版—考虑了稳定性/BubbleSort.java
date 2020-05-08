package com.atguigu.java.sort;

/**
 * 冒泡排序
 * @author shkstart
 * 2013-11-27
 */
public class BubbleSort {
	public static void bubbleSort(DataWrap[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		for (int i = 0; i < arrayLength - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				if (data[j].compareTo(data[j + 1]) > 0) {
					DataWrap temp = data[j + 1];
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
		DataWrap[] data = { new DataWrap(9, ""), new DataWrap(-16, ""),
				new DataWrap(21, "*"), new DataWrap(23, ""),
				new DataWrap(-30, ""), new DataWrap(-49, ""),
				new DataWrap(21, ""), new DataWrap(30, "*"),
				new DataWrap(30, "")};
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		bubbleSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
