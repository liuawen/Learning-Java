package queue.linkedQueueImple;

import queue.arrayQueueImple.QueueADT;
import stack.arrayStackImple.EmptyCollectionException;
import stack.linkedStackImple.LinearNode;

public class LinkedQueue<T> implements QueueADT<T> {
	private int count;
	private LinearNode<T> head, tail;

	public LinkedQueue() {
		this.count = 0;
		this.head = null;
		this.tail = null;
	}

	@Override
	public void enqueue(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		if (isEmpty())
			head = node;
		else
			tail.setNext(node);
		tail = node;
		count++;
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			throw new EmptyCollectionException("Queue");
		T result = head.getElement();
		if (head.getNext() == null)
			tail = null;
		head = head.getNext();
		count--;
		return null;
	}

	@Override
	public T first() {
		return head.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0 ? true : false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
