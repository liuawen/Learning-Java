package codingInterviewGuide.part3tree;

import java.util.Stack;

/**
 * 非递归实现遍历二叉树
 * Created by Dell on 2017-09-03.
 */
public class TraverseTree {
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=null;
        stack.add(root);
        while(!stack.isEmpty()){
                cur=stack.pop();
            System.out.print(cur.val+"   ");
            if(cur.right!=null){stack.add(cur.right);}
            if(cur.left!=null){stack.add(cur.left);}

        }
    }
    public void in(TreeNode root){
        if(root==null){
            return;
        }
        in(root.left);
        System.out.println(root.val+"    ");
        in(root.right);
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.add(root);
        TreeNode cur=root.left;//cur指向栈顶的左孩子
        while(cur!=null||!stack.isEmpty()){//压栈的顺序是左，右，根，
            if(cur==null){
                cur=stack.pop();
                System.out.print(cur.val+"     ");
                cur=cur.right;
            }else{
                stack.add(cur);
                cur=cur.left;
            }
        }
    }
    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.add(root);
        TreeNode cur=root.left;//cur指向栈顶的左孩子
        while(cur!=null||!stack.isEmpty()){//压栈的顺序是左，右，根，
            if(cur==null){
                cur=stack.pop();
                System.out.print(cur.val+"     ");
                cur=cur.right;
            }else{
                stack.add(cur);
                            }
        }
    }










}
