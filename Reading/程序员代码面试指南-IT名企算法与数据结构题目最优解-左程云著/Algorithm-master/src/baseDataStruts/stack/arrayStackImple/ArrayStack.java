package stack.arrayStackImple;

import java.util.Arrays;

/**
 * 该栈栈底位于索引0处 ，JavaAPI中的栈继承自Vector，具有栈向量的双重特性
 * 
 * @author Wangxy
 */
public class ArrayStack<T> implements StackADT<T> {

	private final int DEFAULT_CAPACITY = 100;// 默认容量
	private int top;// 紧跟栈顶元素后的数组索引
	private T[] stack;

	// 有一个警告，但是为了灵活性和泛型的安全性，值得
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		top = 0;
		stack = (T[]) (new Object[DEFAULT_CAPACITY]);// 因为不能实例化一个泛型对象，所以实例化Object，再类型转换一下
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int initCapacity) {
		top = 0;
		stack = (T[]) (new Object[initCapacity]);
	}

	/**
	 * 考虑存满的情况
	 */
	@Override
	public void push(T element) {
		if (size() == stack.length)
			expandCapacity();
		stack[top] = element;
		top++;
	}

	private void expandCapacity() {
		stack = Arrays.copyOf(stack, stack.length * 2);
	}

	/**
	 * 不仅返回，还要将移除的位置置空 处理空集合异常
	 */
	@Override
	public T pop() {
		if (isEmpty())
			throw new EmptyCollectionException("Stack");
		top--;
		T result = stack[top];
		stack[top] = null;
		return result;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyCollectionException("Stack");
		return stack[top - 1];
	}

	@Override
	public boolean isEmpty() {

		return top == 0 ? true : false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top;
	}

}
