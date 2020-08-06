package com.atguigu.java;
/*
 * 算法的考查：数组的复制、反转、查找(线性查找、二分法查找)
 * 
 * 
 */
public class ArrayTest2 {
	
	public static void main(String[] args) {
		
		String[] arr = new String[]{"JJ","DD","MM","BB","GG","AA"};
		
		
		//数组的复制(区别于数组变量的赋值：arr1 = arr)
		String[] arr1 = new String[arr.length];
		for(int i = 0;i < arr1.length;i++){
			arr1[i] = arr[i];
		}
		
		//数组的反转
		//方法一：
//		for(int i = 0;i < arr.length / 2;i++){
//			String temp = arr[i];
//			arr[i] = arr[arr.length - i -1];
//			arr[arr.length - i -1] = temp;
//		}
		
		//方法二：
//		for(int i = 0,j = arr.length - 1;i < j;i++,j--){
//			String temp = arr[i];
//			arr[i] = arr[j];
//			arr[j] = temp;
//		}
		
		//遍历
		for(int i = 0;i < arr.length;i++){
			System.out.print(arr[i] + "\t");
		}
		
		System.out.println();
		//查找（或搜索）
		//线性查找：
		String dest = "BB";
		dest = "CC";
		
		boolean isFlag = true;
		
		for(int i = 0;i < arr.length;i++){
			
			if(dest.equals(arr[i])){
				System.out.println("找到了指定的元素，位置为：" + i);
				isFlag = false;
				break;
			}
			
		}
		if(isFlag){
			System.out.println("很遗憾，没有找到的啦！");
			
		}
		//二分法查找：(熟悉)
		//前提：所要查找的数组必须有序。
		int[] arr2 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
		
		int dest1 = -34;
		dest1 = 35;
		int head = 0;//初始的首索引
		int end = arr2.length - 1;//初始的末索引
		boolean isFlag1 = true;
		while(head <= end){
			
			int middle = (head + end)/2;
			
			if(dest1 == arr2[middle]){
				System.out.println("找到了指定的元素，位置为：" + middle);
				isFlag1 = false;
				break;
			}else if(arr2[middle] > dest1){
				end = middle - 1;
			}else{//arr2[middle] < dest1
				head = middle + 1;
			}

			
		}
		
		if(isFlag1){
			System.out.println("很遗憾，没有找到的啦！");
		}
		
		
	}
}
