package com.atguigu.java.sort;

import java.util.Arrays;

/**
 * 桶式排序
 * 
 * @author shkstart 2013-11-27
 */
public class BucketSort {
	public static void bucketSort(int[] data, int min, int max) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		int[] temp = new int[arrayLength];
		int[] buckets = new int[max - min];
		for (int i = 0; i < arrayLength; i++) {
			buckets[data[i] - min]++;
		}
		System.out.println(Arrays.toString(buckets));
		for (int i = 1; i < max - min; i++) {
			buckets[i] = buckets[i] + buckets[i - 1];
		}
		System.out.println(Arrays.toString(buckets));
		System.arraycopy(data, 0, temp, 0, arrayLength);
		for (int k = arrayLength - 1; k >= 0; k--) {
			data[--buckets[temp[k] - min]] = temp[k];
		}
	}

	public static void main(String[] args) {
		int[] data = { 9, 5, -1, 8, 5, 7, 3, -3, 1, 3 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		bucketSort(data, -3, 10);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
