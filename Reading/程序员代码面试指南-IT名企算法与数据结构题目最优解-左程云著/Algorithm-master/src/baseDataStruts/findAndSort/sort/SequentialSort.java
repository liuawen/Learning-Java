package findAndSort.sort;

/**
 * 顺序排序（选择排序、插入排序、冒泡排序）,三种低效的排序，O(n2)
 * 
 * @author Wangxy
 *
 */
public class SequentialSort<T extends Comparable<? super T>> {
	/**
	 * 插入（已排序）排序：（对前两个值进行排序，后面的值依次插入到已排序的序列中） 从小到大
	 * 
	 * @param data
	 */
	public static <T extends Comparable<? super T>> void insertSort(T[] data) {
		for (int i = 1; i < data.length; i++) {// 选择哪个位置的元素要插入
			T key = data[i];
			// 从右往左，直到给要插入的元素空出位置
			int position = i;// 规定好新排序的界限
			while (position > 0 && data[position - 1].compareTo(key) > 0) {
				data[position] = data[position - 1];
				position--;
			}
			data[position] = key;
			// while (data[j].compareTo(data[i]) > 0) {// 将元素插入到适当的位置
			// if () {
			// // 插入
			// // 其他元素后移
			// // break;
			// }
			//
			// }
		}
	}

	/**
	 * 冒泡排序：（重复比较相邻元素，不符则互换，将最大值冒泡到最后）
	 * 
	 * @param data
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(T[] data) {
		for (int i = 0; i < data.length - 1; i++) {// 控制冒泡的次数
			for (int j = 0; j < data.length - i-1; j++) {// 进行一次冒泡
				if (data[j].compareTo(data[j + 1]) < 0) {// 将小的往后冒
					swap(data, j, j + 1);
				}
			}
		}
	}

	/**
	 * 选择（位置）排序：（扫描整个列表找出最小值，与第一个位置值交换）
	 * 
	 * @param data
	 */
	public static <T extends Comparable<? super T>> void selectSort(T[] data) {
		for (int i = 0; i < data.length - 1; i++) {// 将要排序的位置
			int index = i;
			for (int j = i + 1; j < data.length; j++) {// 记录最小元素的位置
				if (data[j].compareTo(data[index]) < 0) {
					index = j;
				}
			}
			if (index != i)
				swap(data, i, index);
		}
	}

	/**
	 * 交换
	 * 
	 * @param data
	 * @param i
	 * @param index
	 */
	public static <T extends Comparable<? super T>> void swap(T[] data, int i, int index) {
		T temp;
		temp = data[i];
		data[i] = data[index];
		data[index] = temp;
	}
}
