package findAndSort.sort;
/**
 * 对数排序（快速排序和归并排序）
 * @author Dell
 *
 */
public class LogarithmSort {
	/**
	 * 归并排序，将列表递归的分成两半直至每一个子列表只含有一个子元素（可省略），再将子列表两两合并，最终就会有序
	 * 
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] data,int min,int max){
		if(min<max){
			int mid=(min+max)/2;
			mergeSort(data, min, mid);//左区
			mergeSort(data, mid+1, max);//右区
			merge(data,min,mid,max);//合并
		}
	}
	
	/**
	 * 将左区和右区合并，左区内部有序，右区内部有序，注意不要下标越界
	 */
	private static <T extends Comparable<? super T>> void merge(T[] data, int min, int mid, int max) {
		T[] temp=(T[])(new Comparable[data.length]);//可能有空间的浪费，但是移动时较方便
		int first1=min,last1=mid;
		int first2=mid+1,last2=max;
		int index=first1;
		//first去移动，作为当前下标
		//一直去移动，直到某一个区移完
		while(first1<=last1&&first2<=last2){
			//左区下标++，直到该小标元素比右区的当前下标大
			if(data[first1].compareTo(data[first2])<=0){//等于的时候
				temp[index]=data[first1];
				first1++;
			}else{//不等于的时候,左区的当前元素较大，复制右区的
				temp[index]=data[first2];
				first2++;
			}
			index++;
		}
		//将剩余的元素复制
		while(first1<=last1){
			temp[index]=data[first1];
			first1++;
			index++;
		}
		while(first2<=last2){
			temp[index]=data[first2];
			first2++;
			index++;
		}
		//将temp中的复制到data中
		for(index=min;index<=max;index++){
			data[index]=temp[index];
		}
	}








	/**
	 * 快速排序,随机选出一个中间元素，大的放右边，小的放左边，递归完成
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] data,int min,int max){
		if(min<max){
			int soldier=partition(data,min,max);
			quickSort(data, min, soldier-1);
			quickSort(data, soldier+1, max);
		}
	}

	private static <T extends Comparable<? super T>> int partition(T[] data, int min, int max) {
		
		int middle=(min+max)/2;
		T soldierElement=data[middle];
		SequentialSort.swap(data,middle,min);//这样哨兵位于最小索引处，为以后交换做准备
		int left=min;
		int right=max;
		//left和right从两端向中间逼近，只要左边比右边小，循环就一直进行
		while(left<right){
			//left向右移动，考虑左元素不要超过右边界的情况
			while(left<right&&data[left].compareTo(soldierElement)<=0){
				left++;
			}
			//right像左移动，
			while(data[right].compareTo(soldierElement)>0){
				right--;
			}
			//交换，让left和right继续向中间逼近
			if(left<right){
				SequentialSort.swap(data,left,right);
			}
		}
		//将哨兵交换到中间的位置，使用right
		SequentialSort.swap(data,min,right);
		return right;
	}
	
	
//	int soldier=min;
//	//记录哨兵应该在的位置，后边如果有小的，就和哨兵交换
//	for(int i=min+1;i<=max;i++){
//		if(data[i].compareTo(data[soldier])<0){
//			swap(data,i,soldier);
//			soldier++;
//		}
//	}
	
}
