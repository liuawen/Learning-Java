package stack.linkedStackImple;

public interface StackADT<T> {
	/**
	 * 入栈
	 * @param element
	 */
	public void push(T element);
	/**
	 * 出栈
	 * @return
	 */
	public T pop();
	/**
	 * 查看栈顶元素
	 * @return
	 */
	public T peek();
	/**
	 * 判空
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * 查看栈的元素个数
	 * @return
	 */
	public int size();
	
	public String toString();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
