package list.arraylist;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import iterator.Iterator;

/**
 * 重载equals方法以及实现Comparable接口是排序的前提
 * 
 * @author Wangxy
 *
 * @param <T>
 */
public class ArrayListImple<T> {

	private final static int DEFAULT_CAPACITY = 100;
	private final static int NOT_FOUND = -1;
	protected int rear;
	protected T[] list;
	protected int modCount;

	public ArrayListImple() {

	}

	public ArrayListImple(int initialCapacity) {
		rear = 0;
		list = (T[]) new Object[initialCapacity];
		modCount = 0;
	}

	private class ArrayListIterator implements Iterator {
		int iteratorModCount;// 记录通过迭代器修改的数量
		int current;// 当前索引

		public ArrayListIterator() {
			iteratorModCount = modCount;
			current = 0;
		}

		@Override
		public boolean hasNext() {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			return (current < rear);
		}

		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			current++;
			return list[current - 1];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public void add(T element) {
		if (!(element instanceof Comparable))
			throw new NonComparableElement("OrderedList");
		Comparable<T> comparableElement = (Comparable<T>) element;
		if (size() == list.length)
			expandCapacity();
		int scan = 0;
		while (scan < rear && comparableElement.compareTo(list[scan]) > 0)
			scan++;
		for (int shift = rear; shift > scan; shift--)
			list[shift] = list[shift - 1];
		list[scan] = element;
		modCount++;
		rear++;
	}

	public int size() {
		return rear;
	}

	private void expandCapacity() {
		// TODO Auto-generated method stub

	}

	public T remove(T element) {
		T result;
		int index = find(element);
		if (index == NOT_FOUND)
			throw new ElementNotFoundException("ArrayList");
		result = list[index];
		rear--;
		for (int scan = index; scan < rear; scan++) {
			list[scan] = list[scan++];
		}
		list[rear] = null;
		modCount++;
		return result;
	}

	private int find(T target) {
		int scan = 0;
		int index = NOT_FOUND;
		if (!isEmpty())
			while (scan < rear && index == NOT_FOUND)
				if (target.equals(list[scan]))
					index = scan;
				else
					scan++;
		return index;
	}

	public boolean isEmpty() {
		return false;
	}

}
