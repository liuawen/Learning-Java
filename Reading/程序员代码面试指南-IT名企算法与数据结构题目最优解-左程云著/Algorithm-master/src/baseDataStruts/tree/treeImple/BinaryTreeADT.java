package tree.treeImple;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
	T getRootElement();
	boolean isEmpty();
	int size();
	boolean contains(T targetElement);
	T find(T targetElement);
	Iterator<T> iterator();
	/**
	 * 中序遍历
	 * @return
	 */
	Iterator<T> iteratorInOrder();
	/**
	 * 前序遍历
	 * @return
	 */
	Iterator<T> iteratorPreOrder();
	/**
	 * 后序遍历
	 * @return
	 */
	Iterator<T> iteratorPostOrder();
	/**
	 * 层序遍历
	 * @return
	 */
	
	Iterator<T> iteratorLevelOrder();
}
