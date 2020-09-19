package stack.linkedStackImple;

import stack.arrayStackImple.EmptyCollectionException;

/**
 * 从列表的一端添加和删除元素，栈顶设计在链表的前端，避免插入删除遍历整个链表，可以提高效率
 * 
 * @author Wangxy
 */
public class LinkedStack<T> implements StackADT<T> {
	private int count;
	private LinearNode<T> top;// 指向栈顶的指针,没有头结点

	@Override
	public void push(T element) {
		LinearNode<T> newNode = new LinearNode(element);
		// 将该节点插入到链表中
		newNode.setNext(top);
		top = newNode;
		count++;
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new EmptyCollectionException("Stack");
		T result = top.getElement();
		top = top.getNext();
		count--;
		return result;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyCollectionException("Stack");
		T result = top.getElement();
		return result;
	}

	@Override
	public boolean isEmpty() {
		return count == 0 ? true : false;
	}

	@Override
	public int size() {
		return count;
	}

}
