package part7tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 非递归遍历二叉树
 * Created by Dell on 2017-07-26.
 */
public class NoTreeToSequence {
    public int[][] convert(TreeNode root) {
        int[][] res=new int[3][];
        ArrayList<Integer> pre=new ArrayList<Integer>();
        ArrayList<Integer> in=new ArrayList<Integer>();
        ArrayList<Integer> post=new ArrayList<Integer>();
        preOrder(root,pre);
        inOrder(root,in);
//        postOrder(root,post);
        res[0]=transeArray(pre);
        res[1]=transeArray(in);
        res[2]=transeArray(post);
        return res;
    }

    /**
     * 非递归的先序,使用一个栈模拟
     * @param root
     * @param pre
     */
    private void preOrder(TreeNode root, ArrayList<Integer> pre) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            pre.add(root.val);
            if(root.right!=null){
                stack.add(root.right);
            }
            if(root.left!=null){
                stack.add(root.left);
            }
        }
    }

    private void inOrder(TreeNode root, ArrayList<Integer> in) {
        if(root!=null){
            //使用cur，stack来记录
            Stack<TreeNode> stack=new Stack<TreeNode>();
            TreeNode cur=root;
            while(cur!=null&&!stack.isEmpty()){
                if(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else{
                    cur = stack.pop();
                    in.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
    //TODO 二叉树中序后序遍历
    //后序遍历,
//    private void postOrder(TreeNode root, ArrayList<Integer> post) {
//        if(root!=null){
//            Stack<TreeNode> stack=new Stack<TreeNode>();
//            TreeNode cur=null;
//            stack.add(root);
//            while(!stack.isEmpty()){
//                cur=stack.peek();
//                if(cur.right)
//            }
//        }
//    }
    private int[] transeArray(ArrayList<Integer> list){
        int[] res=new int[list.size()];
        int count=0;
        for(Integer i:list){
            res[count++]=i;
        }
        return res;
    }
}
