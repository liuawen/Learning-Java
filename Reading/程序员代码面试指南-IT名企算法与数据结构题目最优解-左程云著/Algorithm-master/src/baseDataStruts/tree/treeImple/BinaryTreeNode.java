package tree.treeImple;

public class BinaryTreeNode<T> {


	protected T element;
	protected BinaryTreeNode<T> left,right;
	
	/**
	 * 创建节点，只有该节点存储的元素
	 * @param obj
	 */
	public BinaryTreeNode(T obj){
		this.element=obj;
		this.left=null;
		this.right=right;
	}
	public BinaryTreeNode(T obj,LinkedBinaryTree<T> left,LinkedBinaryTree<T> right){
		this.element=obj;
		if(left==null){
			this.left=null;
		}else{
			this.left=left.getRoot();
		}
		if(right==null){
			this.right=null;
		}else{
			this.right=right.getRoot();
		}
	}

    /**
	 * 用于返回给定结点的孩子数，递归
	 * @return
	 */
	public int numChildren(){
		int children=0;
		if(left!=null)
			children=1+left.numChildren();
		
		if(right!=null)
			children=1+right.numChildren();
		return children;
	}
	
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	
	
	
	
	
	
	
	
}
