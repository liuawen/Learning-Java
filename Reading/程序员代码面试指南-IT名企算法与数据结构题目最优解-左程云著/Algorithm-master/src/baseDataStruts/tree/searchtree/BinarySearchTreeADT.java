package tree.searchtree;

import tree.treeImple.BinaryTreeADT;

/**
 * Created by Dell on 2017-04-05.
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    public void addElement(T element);
    public T removeElement(T targetElement);
    public void removeAllOccurances(T targetElement);
    public T removeMin();
    public T removeMax();
    public T findMin();
    public T findMax();
}
