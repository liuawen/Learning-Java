package com.atguigu.java.sort;

/**
 * 归并排序
 * 
 * @author shkstart 
 * 2013-11-27
 */
public class MergeSort {
	public static void mergeSort(DataWrap[] data) {
		// 归并排序
		sort(data, 0, data.length - 1);
	}

	// 将索引从left到right范围的数组元素进行归并排序
	private static void sort(DataWrap[] data, int left, int right) {
		if(left < right){
			//找出中间索引
			int center = (left + right)/2;
			sort(data,left,center);
			sort(data,center+1,right);
			//合并
			merge(data,left,center,right);
		}
	}

	// 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
	private static void merge(DataWrap[] data, int left, int center, int right) {
		DataWrap[] tempArr = new DataWrap[data.length];
		int mid = center + 1;
		int third = left;
		int temp = left;
		while (left <= center && mid <= right) {
			if (data[left].compareTo(data[mid]) <= 0) {
				tempArr[third++] = data[left++];
			} else {
				tempArr[third++] = data[mid++];
			}
		}
		while (mid <= right) {
			tempArr[third++] = data[mid++];
		}
		while (left <= center) {
			tempArr[third++] = data[left++];
		}
		while (temp <= right) {
			data[temp] = tempArr[temp++];
		}
	}

	public static void main(String[] args) {
		DataWrap[] data = { new DataWrap(9, ""), new DataWrap(-16, ""),
				new DataWrap(21, "*"), new DataWrap(23, ""),
				new DataWrap(-30, ""), new DataWrap(-49, ""),
				new DataWrap(21, ""), new DataWrap(30, "*"),
				new DataWrap(30, "") };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		mergeSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
