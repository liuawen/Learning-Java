package nowCoderClass1.section7.noRecursion;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 * Created by Dell on 2017-05-12.
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        // write code here
        int[][] rr=new int[3][];
        rr[0]=preOrder(root);
        return rr;
    }
    public int[] inOrder(TreeNode root){
        if(root==null)
            return null;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        /**
         * 中序遍历，先将左一直往栈中压，直到左为空，取出一个，打印，再将其右往栈压，
         */
        ArrayList<Integer> list=new ArrayList<Integer>();
        TreeNode current=root;
        while(!(stack.isEmpty()&&current==null)){
            if(current==null){
                current=stack.pop();
                list.add(current.val);
                current=current.right;
            }else{
                stack.add(current);
                current=current.left;
            }
        }
        int[] res=new int[list.size()];
        //将ArrayList变为数组返回
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
    /**
     * 利用栈实现非递归,先序遍历
     * @param root
     * @return
     */
    public int[] preOrder(TreeNode root){
        if(root==null)
            return null;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        /**
         * 先序遍历，先将根压栈，然后弹出根，将右压栈，然后访问左，将右压栈。
         */
        stack.add(root);
        TreeNode current=null;
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            current=stack.pop();
            if(current.right!=null){
                stack.add(current.right);
            }
            list.add(current.val);
            if(current.left!=null){
                stack.add(current.left);
            }
        }
        int[] res=new int[list.size()];
        //将ArrayList变为数组返回
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
