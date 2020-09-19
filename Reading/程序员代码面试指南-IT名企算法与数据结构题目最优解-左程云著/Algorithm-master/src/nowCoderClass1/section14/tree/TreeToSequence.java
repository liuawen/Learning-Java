package nowCoderClass1.section14.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Dell on 2017-06-20.
 */
public class TreeToSequence {
    /**
     * 返回二叉树的先序、中序、后序的非递归实现
     * @param root
     * @return
     */
//    public int[][] convert(TreeNode root) {
//        // write code here
//    }
    //先序遍历，非递归
    public int[] preOrder(TreeNode root){
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        int[] res=null;
        if(root!=null){
            stack.add(root);
            TreeNode cur=null;
            while(!stack.isEmpty()){
                cur=stack.pop();
                list.add(cur.val);
                if(cur.right!=null){
                    stack.add(cur.right);
                }
                if(cur.left!=null){
                    stack.add(cur.left);
                }
            }
            //将list转成int
            res=new int[list.size()];
            int index=0;
            for(Integer val:list){
                res[index++]=val;
            }
        }
        return res;
    }
    public int[] inOrder(TreeNode root){
        int[] res=null;
        if(root!=null){
            ArrayList<Integer> list=new ArrayList<Integer>();
            Stack<TreeNode> stack=new Stack<TreeNode>();
            TreeNode cur=root;//使用这个来记录当前操作的节点
            // 中序遍历，先将左一直往栈中压，直到左为空，取出一个，打印，再将其右往栈压，
            while(!(stack.isEmpty()&&cur==null)){
                if(cur!=null){
                    stack.add(cur);
                    cur=cur.left;
                }else{
                    cur=stack.pop();
                    list.add(cur.val);
                    cur=cur.right;
                }
            }

            //将list转成int
            res=new int[list.size()];
            int index=0;
            for(Integer val:list){
                res[index++]=val;
            }
        }
        return res;
    }

    /**
     * 利用栈，将树的右孩子
     * @param root
     * @return
     */
    public int[] postOrder(TreeNode root) {
        int[] res = null;
        if (root != null) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode cur = root;//使用这个来记录当前操作的节点
            while(!(stack.isEmpty()&&cur==null)){
                if(cur!=null){
                    stack.add(cur);
                    if(cur.right!=null){
                        stack.add(cur.right);
                    }
                    cur=cur.left;
                }else{
                    cur=stack.pop();
                    list.add(cur.val);
                    cur=null;
                }
            }

            //将list转成int
            res=new int[list.size()];
            int index=0;
            for(Integer val:list){
                res[index++]=val;
            }
        }
        return res;
    }
}
