package findAndSort.find;

/**
 * 泛型声明的类，表示只有实现了Comparable接口的类才能使用此类中的方法
 * 
 * @author Wangxy
 *
 * @param <T>
 */
public class Searching<T extends Comparable<T>> {

	/**
	 * 线性查找，没有顺序要求 使用泛型方法，只需在返回值前插入一个泛型声明即可,
	 * 
	 * @param data
	 * @param min
	 * @param max
	 * @param target
	 * @return
	 */
	public static <T extends Comparable<? super T>> boolean linearSearch(T[] data, int min, int max, T target) {
		// 该集合是未排序的
		int index = min;
		boolean found = false;
		while (!found && index <= max) {
			if (data[index].compareTo(target) == 0)
				found = true;
			else
				index++;
		}
		return found;
	}

	/**
	 * 二分查找，要求集合是已排序的，注意判断时的等于号
	 */
	public static <T extends Comparable<? super T>> boolean binarySearch(T[] data, int min, int max, T target) {
		// int midPoint = (min + max) / 2;
		// boolean found = false;
		// if (data[midPoint].compareTo(target) == 0)// ==
		// found = true;
		// else if (data[midPoint].compareTo(target) > 0) {// 大于
		// if (min <= midPoint - 1)
		// found = binarySearch(data, min, midPoint - 1, target);//
		// midPoint应-1，因为midPoint点已被排除
		// } else// 小于
		// if (midPoint + 1 <= max)
		// found = binarySearch(data, midPoint + 1, max, target);
		// return found;
		boolean result = false;
		int mid = (min + max) / 2;
		if (target.compareTo(data[mid]) == 0)
			result = true;
		else if (target.compareTo(data[mid]) < 0) {// target小
			if (min <= mid - 1) {
				result = binarySearch(data, min, mid - 1, target);
			}
		} else {// target大
			if (mid + 1 <= max) {
				result = binarySearch(data, mid + 1, max, target);
			}
		}
		return result;
	}

}
