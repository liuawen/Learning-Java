package test;

import findAndSort.find.Searching;
import findAndSort.sort.LogarithmSort;
import findAndSort.sort.SequentialSort;

public class Test {
	public static void main(String[] args) {
		String[] array = { "a10", "b51", "r25", "p63", "47", "f15" };
		LogarithmSort.mergeSort(array, 0, 5);
//		SequentialSort.insertSort(array);
		
		for (String string : array) {
			System.out.print(string+"        ");
		}
		
//		System.out.println(array[0].compareTo(array[1]));
//		if (Searching.binarySearch(array, 0, 5, 0)) {
//			System.out.println("找到了");
//		} else {
//			System.out.println("没找到");
//		}
	}
	
}
