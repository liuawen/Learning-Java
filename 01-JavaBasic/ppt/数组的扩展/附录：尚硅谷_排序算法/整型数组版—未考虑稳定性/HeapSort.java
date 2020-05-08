package com.atguigu.java.sort;

/**
 * 堆排序
 * 
 * @author shkstart 2013-11-27
 */
public class HeapSort {
	public static void heapSort(int[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxdHeap(data, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			swap(data, 0, arrayLength - 1 - i);
			System.out.println(java.util.Arrays.toString(data));
		}
	}

	// 对data数组从0到lastIndex建大顶堆
	private static void buildMaxdHeap(int[] data, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存当前正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex +1
				// 代表k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 如果右子节点的值较大
					if (data[biggerIndex] - data[biggerIndex + 1] < 0) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大子节点的值
				if (data[k] - data[biggerIndex] < 0) {
					// 交换它们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋给k，开始while循环的下一次循环
					// 重新保证k节点的值大于其左、右节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	// 交换data数组中i、j两个索引处的元素
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int[] data = { 9, -16, 21, 23, -30, -49, 21, 30, 30 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		heapSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
