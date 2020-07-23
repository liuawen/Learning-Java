package com.atguigu.java.sort;

/**
 * 快速排序
 * @author shkstart
 * 2013-11-27
 */
public class QuickSort {
	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static void subSort(DataWrap[] data, int start, int end) {
		if (start < end) {
			DataWrap base = data[start];
			int i = start;
			int j = end + 1;
			while (true) {
				while (i < end && data[++i].compareTo(base) <= 0)
					;
				while (j > start && data[--j].compareTo(base) >= 0)
					;
				if (i < j) {
					swap(data, i, j);
				} else {
					break;
				}
			}
			swap(data, start, j);
			subSort(data, start, j - 1);
			subSort(data, j + 1, end);
		}
	}
	public static void quickSort(DataWrap[] data){
		subSort(data,0,data.length-1);
	}
	public static void main(String[] args) {
		DataWrap[] data = { new DataWrap(9, ""), new DataWrap(-16, ""),
				new DataWrap(21, "*"), new DataWrap(23, ""),
				new DataWrap(-30, ""), new DataWrap(-49, ""),
				new DataWrap(21, ""), new DataWrap(30, "*"),
				new DataWrap(30, "") };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		quickSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
