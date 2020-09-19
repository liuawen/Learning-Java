package stack.linkedStackImple;

/**
 * 结点类（两个引用），一个指向链表的下一个结点，另一个指向结点中存储的元素; 存储在集合中的对象不应该包含基本数据结构的实现细节
 * 
 * @author Wangxy
 *
 * @param <T>
 */
public class LinearNode<T> {
	private LinearNode<T> next;
	private T element;

	public LinearNode() {
		next = null;
		element = null;
	}

	public LinearNode(T element) {
		this.next = null;
		this.element = element;
	}

	public LinearNode<T> getNext() {
		return next;
	}

	public void setNext(LinearNode<T> next) {
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}
