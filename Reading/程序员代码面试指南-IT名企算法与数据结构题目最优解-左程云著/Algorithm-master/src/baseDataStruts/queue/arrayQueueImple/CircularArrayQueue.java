package queue.arrayQueueImple;

import java.util.Arrays;

import stack.arrayStackImple.EmptyCollectionException;

/**
 * 非环形数组会导致元素移位，产生O(n)的复杂度
 * 
 * @author Wangxy
 *
 * @param <T>
 */
public class CircularArrayQueue<T> implements QueueADT<T> {
	private final int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;

	public CircularArrayQueue() {
		this.front = 0;
		this.rear = 0;
		this.count = 0;
		this.queue = (T[]) new Object[DEFAULT_CAPACITY];
	}

	public CircularArrayQueue(int initialCapacity) {
		this.front = 0;
		this.rear = 0;
		this.count = 0;
		this.queue = (T[]) new Object[initialCapacity];
	}

	@Override
	public void enqueue(T element) {
		if (size() == queue.length)
			expandCapacity();
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	private void expandCapacity() {
		int oldLength = queue.length;
		queue = Arrays.copyOf(queue, oldLength * 2);
		// front不变，rear和front相等时，将0-rear的元素存到queue.length -queue.length+rear的位置
		if (front != 0) {// 要将环形数组的末端（之前存在数组前端的），移至数组的末端
			for (int i = 0; i < rear; i++) {
				queue[oldLength + i] = queue[i];
			}
			rear = oldLength + rear;
		}
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			throw new EmptyCollectionException("Queue");
		T result = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		count--;
		return result;
	}

	@Override
	public T first() {
		return queue[front];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0 ? true : false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
