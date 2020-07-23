package com.atguigu.java.sort;
/**
 * Shell排序
 * @author shkstart
 * 2013-11-27
 */

public class ShellSort {
	public static void ShellSort(DataWrap[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;

		int h = 1;
		while (h <= arrayLength / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			System.out.println("===h的值：" + h + "===");
			for (int i = h; i < arrayLength; i++) {
				DataWrap temp = data[i];
				if (data[i].compareTo(data[i - h]) < 0) {
					int j = i - h;
					for (; j >= 0 && data[j].compareTo(temp) > 0; j -= h) {
						data[j + h] = data[j];
					}
					data[j + h] = temp;
				}
				System.out.println(java.util.Arrays.toString(data));
			}
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) {
		DataWrap[] data = { 
				new DataWrap(9, ""), new DataWrap(-16, ""),
				new DataWrap(21, "*"), new DataWrap(23, ""),
				new DataWrap(-30, ""), new DataWrap(-49, ""),
				new DataWrap(21, ""), new DataWrap(30, "*"),
				new DataWrap(30, "")};
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		ShellSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
