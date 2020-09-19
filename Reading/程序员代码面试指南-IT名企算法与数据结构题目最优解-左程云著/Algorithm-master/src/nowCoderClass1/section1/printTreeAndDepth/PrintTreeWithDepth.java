package nowCoderClass1.section1.printTreeAndDepth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层打印二叉树，并换行
 * Created by Dell on 2017-04-13.
 */
public class PrintTreeWithDepth<T> {


    /**
     * 传入一颗二叉树，按层打印，宽度优先遍历，并且打印行号
     * 加入一个计数的即可
     * @param root
     */
    public static <T> void printTreeWithDepth(BinaryTreeNode<T> root){
        //使用队列来存放二叉
        Queue<BinaryTreeNode<T>> queue=new LinkedList<BinaryTreeNode<T>>();
        BinaryTreeNode<T> last;
        BinaryTreeNode<T> nextLast=null;
        int count=1;
        if(root!=null){
            queue.add(root);
            last=root;
            System.out.print(count+":       ");
            //只要不为空，就打印这个节点
            while(queue.size()!=0){
                BinaryTreeNode<T> now=queue.remove();
                System.out.print(now.element+"      ");

                if(now.left!=null){
                    queue.add(now.left);
                    nextLast=now.left;
                }
                if(now.right!=null){
                    queue.add(now.right);
                    nextLast=now.right;
                }
                if(now.equals(last)){
                    //当前节点和last节点相同，说明该换行了
                    System.out.println();
                    last=nextLast;
                    System.out.print(count+":       ");
                }
            }
        }else
            System.out.println("此二叉树为空");
    }

    /**
     * 传入一颗二叉树，按层打印,并换行
     * 加入两个变量last和nextlast，分别记录当前层的最有节点和下一层的最右节点
     * @param root
     */
    public static <T> void printTreeWithBr(BinaryTreeNode<T> root){
        //使用队列来存放二叉
        Queue<BinaryTreeNode<T>> queue=new LinkedList<BinaryTreeNode<T>>();
        BinaryTreeNode<T> last;
        BinaryTreeNode<T> nextLast=null;
        if(root!=null){
            queue.add(root);
            last=root;
            //只要不为空，就打印这个节点
            while(queue.size()!=0){
                BinaryTreeNode<T> now=queue.remove();
                System.out.print(now.element+"      ");

                if(now.left!=null){
                    queue.add(now.left);
                    nextLast=now.left;
                }
                if(now.right!=null){
                    queue.add(now.right);
                    nextLast=now.right;
                }
                if(now.equals(last)){
                    //当前节点和last节点相同，说明该换行了
                    System.out.println();
                    last=nextLast;
                }
            }
        }else
            System.out.println("此二叉树为空");
    }

    /**
     * 传入一颗二叉树，按层打印，宽度优先遍历
     * @param root
     */
    public static <T> void printTree(BinaryTreeNode<T> root){
        //使用队列来存放二叉
        Queue<BinaryTreeNode<T>> queue=new LinkedList<BinaryTreeNode<T>>();
        if(root!=null){
            queue.add(root);
            //只要不为空，就打印这个节点
            while(queue.size()!=0){
                BinaryTreeNode<T> now=queue.remove();
                System.out.print(now.element+"      ");
                if(now.left!=null)
                    queue.add(now.left);
                if(now.right!=null)
                    queue.add(now.right);
            }
        }else
            System.out.println("此二叉树为空");
    }
}
