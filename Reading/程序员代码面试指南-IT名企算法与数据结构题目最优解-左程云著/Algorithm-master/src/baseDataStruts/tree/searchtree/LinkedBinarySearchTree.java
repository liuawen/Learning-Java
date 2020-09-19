package tree.searchtree;

import list.arraylist.ElementNotFoundException;
import list.arraylist.NonComparableElement;
import stack.arrayStackImple.EmptyCollectionException;
import tree.treeImple.BinaryTreeNode;

import java.util.Iterator;

/**
 * Created by Dell on 2017-04-06.
 */
public class LinkedBinarySearchTree<T> implements BinarySearchTreeADT<T> {

    private BinaryTreeNode root=null;
    private int modCount;

    public LinkedBinarySearchTree() {
        super();
    }
    public LinkedBinarySearchTree(T element) {
        if(!(element instanceof Comparable)){
            throw new NonComparableElement("LinkedBinarySearchTree");
        }

    }
    @Override
    public void addElement(T element) {
        if(!(element instanceof Comparable)){
            throw new NonComparableElement("LinkedBinarySearchTree");
        }
        Comparable<T> comparableElement=(Comparable<T>)element;

        if(isEmpty())
            root=new BinaryTreeNode(element);
        else
        {//根节点不空
            T rootElement= (T) root.getElement();
            if(comparableElement.compareTo(rootElement)<0){
                if(root.getLeft()==null)
                    root.setLeft(new BinaryTreeNode(element));
                else
                    addElement(element,root.getLeft());
            }else{
                if(root.getRight()==null)
                    root.setRight(new BinaryTreeNode(element));
                else
                    addElement(element,root.getRight());
            }
        }
    }

    /**
     * 支持方法
     * @param element
     * @param node
     */
    private void addElement(T element, BinaryTreeNode<T> node) {
        Comparable<T> comparableElement=(Comparable<T>) element;
        T rootElement= (T) node.getElement();
        if(comparableElement.compareTo(rootElement)<0){
            if(root.getLeft()==null)
                root.setLeft(new BinaryTreeNode(element));
            else
                addElement(element,node.getLeft());
        }else{
            if(root.getRight()==null)
                root.setRight(new BinaryTreeNode(element));
            else
                addElement(element,node.getRight());
        }
    }

    /**
     * 删除节点时必须推出一个节点来代替它
     * @param targetElement
     * @return
     */
    @Override
    public T removeElement(T targetElement) {
    //三种情况：没有孩子，有一个孩子，有两个孩子
        T result=null;
        if(isEmpty()){
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        }else{
            //找到要删除的节点
            BinaryTreeNode<T> parent=null;//用来记录比较的元素
            if(((Comparable<T>)targetElement).compareTo((T)root.getElement())==0){
                //根节点是需要删除的节点
                BinaryTreeNode<T> temp=replacement(root);
                if(temp==null){
                    root=null;
                }else{
                    root.setElement(temp.getElement());
                    root.setLeft(temp.getLeft());
                    root.setRight(temp.getRight());
                }
                modCount--;
            }else{//根节点不是要删除的节点
                parent=root;
                if(((Comparable<T>)targetElement).compareTo((T)root.getElement())<0)
                    result=(T)removeElement(targetElement,root.getLeft(),parent);
                else
                    result=(T)removeElement(targetElement,root.getRight(),parent);
            }
        }
        return result;
    }

    /**
     *
     * @param targetElement  要删的
     * @param root
     * @param parent
     * @return
     */
    private T removeElement(T targetElement,BinaryTreeNode<T> node, BinaryTreeNode<T> parent){
        T result=null;
        if(node==null)
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else{
            if(((Comparable<T>)node).compareTo((T)targetElement)==0){
                    result=node.getElement();
                    //选择一个替代的节点
                    BinaryTreeNode<T> temp=replacement(node);
                    //选择替代的节点之后要考虑将替代节点和父节点关联起来
                    if(parent.getLeft()==node)
                        parent.setLeft(temp);
                    else
                        parent.setRight(temp);
                    modCount--;
            }else{
                parent=node;
                if(((Comparable<T>)targetElement).compareTo((T)parent.getElement())<0)
                    result=removeElement(targetElement,node.getLeft(),parent);
                else
                    result=removeElement(targetElement,node.getRight(),parent);
            }
        }
        return result;
    }

    /**
     *找出一个节点，替换删去的节点
     * @param root 这是要删去的节点
     * @return
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode root) {
        BinaryTreeNode<T> result=null;
        //左右全为空
        if(root.getLeft()==null&&root.getRight()==null)
            result=null;
        //只有一个节点
        else if(root.getLeft()==null&&root.getRight()!=null)
            result=root.getRight();
        else if (root.getLeft()!=null&&root.getRight()==null)
            result=root.getLeft();
        else{//两个节点全有,选出一个节点替代
            BinaryTreeNode<T> current=root.getRight();//current记录要删除的节点的替代节点，未来的根
            BinaryTreeNode<T> parent=root;//parent,只是用来记录新根的父节点
            //找删去节点的中序后继者，也就是右子树的最左节点
            while(current.getLeft()!=null){
                parent=current;
                current=current.getLeft();
            }
            //将删除节点的左子树赋给新根的左边
            current.setLeft(root.getLeft());
            //判断current是否和删除节点的右节点相同，相同则不用转换
            if(root.getRight()!=current)
            {
                //将替代节点的右子树变成parent的左子树
                parent.setLeft(current.getRight());
                //将删除节点的右子树变成替代节点的右子树
                current.setRight(root.getRight());
            }
            result=current;
         }
        return result;
    }

    /**
     * 最左侧节点是最小的
     * @return
     */
    @Override
    public T removeMin() {
        T result=null;
        if(isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else{
            //根就是最小的
            if(root.getLeft()==null)
                result=(T)root.getElement();
            else{
                //递归找最左节点
                BinaryTreeNode<T> parent=root;
                BinaryTreeNode<T> current=root.getLeft();
                while(current.getLeft()!=null){
                    parent=current;
                    current=current.getLeft();
                }
                //最小的是叶子节点，
                // 最小的是内部节点
                result=current.getElement();
                parent.setLeft(current.getRight());
            }
            modCount--;
        }
        return result;
    }






    @Override
    public T getRootElement() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object targetElement) {
        return false;
    }

    @Override
    public Object find(Object targetElement) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Iterator iteratorInOrder() {
        return null;
    }

    @Override
    public Iterator iteratorPreOrder() {
        return null;
    }

    @Override
    public Iterator iteratorPostOrder() {
        return null;
    }

    @Override
    public Iterator iteratorLevelOrder() {
        return null;
    }





    @Override
    public void removeAllOccurances(Object targetElement) {

    }



    @Override
    public T removeMax() {
        return null;
    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }
}

