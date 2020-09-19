package tree.treeImple;

import list.arraylist.ElementNotFoundException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>,Iterable<T>  {
	public BinaryTreeNode<T> root;
	public int modCount;


	public LinkedBinaryTree(){
		root=null;//创建一颗空二叉树
	}

	public LinkedBinaryTree(T element){
		root=new BinaryTreeNode<T>(element);//用单个元素创建一颗二叉树
	}

	public LinkedBinaryTree(T element,LinkedBinaryTree<T> left,LinkedBinaryTree<T> right){
		root=new BinaryTreeNode<T>(element);//根节点的元素
		root.setLeft(left.root);//根节点的左树，右树
		root.setRight(right.root);
	}
	@Override
	public T getRootElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T targetElement) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 与树关联的，大多是迭代或者递归，使用一个私有支持方法，区分find方法的第一次调用和随后的每个调用
	 */
	@Override
	public T find(T targetElement) {
	BinaryTreeNode<T> current=findAgain(targetElement,root);
	if(current==null)
	throw new ElementNotFoundException("binary tree");
	return current.element;
	}

	private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
		if(next==null)
			return null;
		if(next.element.equals(targetElement))
			return next;
		BinaryTreeNode<T> temp=findAgain(targetElement,next.left);
		if(temp==null){
			temp=findAgain(targetElement,next.right);
		}
		return temp;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 创建一个Iterator对象，允许一个用户类在 中序遍历 中单步遍历树的元素
	 * @return
	 */
	@Override
	public Iterator<T> iteratorInOrder() {//中序遍历
		Queue<T> tempQueue=new LinkedList<T>();
		inorder(root,tempQueue);
		return tempQueue.iterator();
	}

	private void inorder(BinaryTreeNode<T> node, Queue<T> tempQueue) {
		if(node!=null){
			//左根右
			inorder(node.left,tempQueue);
			tempQueue.add(node.element);
			inorder(node.right,tempQueue);
		}
	}
	//前序遍历,根左右
	@Override
	public Iterator<T> iteratorPreOrder() {
		Queue<T> tempQueue=new LinkedList<T>();
		preorder(root,tempQueue);
		return tempQueue.iterator();
	}

	private void preorder(BinaryTreeNode<T> node, Queue<T> tempQueue) {
		if(node!=null){
			//前序遍历,根左右
			tempQueue.add(node.element);
			preorder(node.left,tempQueue);
			preorder(node.right,tempQueue);
		}
	}

	//后序遍历，左右根
	@Override
	public Iterator<T> iteratorPostOrder() {
		Queue<T> tempQueue=new LinkedList<T>();
		postorder(root,tempQueue);
		return tempQueue.iterator();
	}

	private void postorder(BinaryTreeNode<T> node, Queue<T> tempQueue) {
		if(node!=null){
			//前序遍历,左右根

			postorder(node.left,tempQueue);
			postorder(node.right,tempQueue);
			tempQueue.add(node.element);
		}
	}
	//层序遍历
	@Override
	public Iterator<T> iteratorLevelOrder() {
		Queue<BinaryTreeNode<T>> nodes=new LinkedList<BinaryTreeNode<T>>();//存放需要依次查看的层的节点
		List<T> results=new LinkedList<T>();//结果
		//根节点入队
		nodes.add(root);
		while(!nodes.isEmpty()){
			BinaryTreeNode<T> current=nodes.remove();
			if(current!=null) {
				results.add(current.element);
				//该元素的孩子节点 入队
				nodes.add(current.left);
				nodes.add(current.right);
			}
		}
		return results.iterator();
	}

	public <T> BinaryTreeNode<T> getRoot() {
		return (BinaryTreeNode<T>) root;
	}
}
