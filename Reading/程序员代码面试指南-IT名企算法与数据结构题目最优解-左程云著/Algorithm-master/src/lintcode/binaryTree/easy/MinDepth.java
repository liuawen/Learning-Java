package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class MinDepth {
    //最小深度，必须是叶子节点，才可以
    public int minDepth(TreeNode root) {
        return help(root,0);
    }
    public int help(TreeNode root,int curDepth){
        if(root==null)
            return curDepth;
        if(root.left==null&&root.right==null){
            return curDepth+1;
        }
        int left=0;
        if(root.left!=null){
            left=help(root.left,curDepth+1);
        }
        int right =0;
        if(root.right!=null) {
            right = help(root.right, curDepth + 1);
        }
        if(left!=0&&right!=0){
            return Math.min(left,right);
        }
        return left==0?right:left;
    }
}
