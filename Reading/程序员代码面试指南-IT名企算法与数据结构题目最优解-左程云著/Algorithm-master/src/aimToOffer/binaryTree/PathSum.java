package binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Dell on 2017-06-10.
 */
public class PathSum {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(root==null||target==0)
            return list;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        findPath(root,target,list,stack);
        return list;
    }
    public void findPath(TreeNode current, int target, ArrayList<ArrayList<Integer>> list, Stack<TreeNode> stack){
        if(current.left==null&&current.right==null){//此节点为叶子节点
            stack.add(current);
            if(current.val==target){//等于
                //将栈中的元素全部取出
                ArrayList<Integer> path=new ArrayList<Integer>();
                Iterator<TreeNode> iterator=stack.iterator();//从栈底向栈顶
                while (iterator.hasNext())
                    path.add(iterator.next().val);
                list.add(path);
            }
        }else{//还有叶节点
            stack.add(current);
            if(current.left!=null){
                findPath(current.left,target-current.val,list,stack);
                stack.pop();//弹出左孩子
            }
            if(current.right!=null){
                findPath(current.right,target-current.val,list,stack);
                stack.pop();
            }
        }
    }
}
