package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017-09-01.
 */
public class PathSum {
    //用递归做,深度优先遍历
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        if(root!=null) {
            traverse(root, target, lists, new ArrayList<Integer>());
        }
        return lists;
    }
    //约定，调用时root不可为空，
    public void traverse(TreeNode root,int target,List<List<Integer>> lists,List<Integer> list){
        if(root.left==null&&root.right==null){
            target-=root.val;
            list.add(root.val);
             if(target==0){
                 lists.add(new ArrayList<Integer>(list));
             }
             list.remove(list.size()-1);
             return;
        }
        list.add(root.val);
        if(root.left!=null){
            traverse(root.left,target-root.val,lists,list);
        }
        if(root.right!=null){
            traverse(root.right,target-root.val,lists,list);
        }
        list.remove(list.size()-1);
    }

}
