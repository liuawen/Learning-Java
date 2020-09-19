package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Dell on 2017-06-21.
 */
public class PrintSShape {
    //像之字形打印二叉树，即一行从左向右，一行从右向左
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return lists;
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        TreeNode cur=null;//这是每一层的最后一个节点
        stack1.add(pRoot);
        while(!(stack1.isEmpty()&&stack2.isEmpty())){//每次遍历一层
            ArrayList<Integer> list=new ArrayList<Integer>();
            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    cur=stack1.pop();
                    list.add(cur.val);
                    if(cur.left!=null){
                        stack2.add(cur.left);
                    }
                    if(cur.right!=null){
                        stack2.add(cur.right);
                    }
                }
            }else{
                while(!stack2.isEmpty()){
                    cur=stack2.pop();
                    list.add(cur.val);
                    if(cur.right!=null){
                        stack1.add(cur.right);
                    }
                    if(cur.left!=null){
                        stack1.add(cur.left);
                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
