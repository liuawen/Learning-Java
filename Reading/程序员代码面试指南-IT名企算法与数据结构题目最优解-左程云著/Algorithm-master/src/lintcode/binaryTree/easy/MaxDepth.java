package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // write your code here
        return help(root,0);
    }
    public int help(TreeNode root,int curDepth){
        if(root==null){
            return curDepth;
        }
        int left=help(root.left,curDepth+1);
        int right=help(root.right,curDepth+1);
        return Math.max(left,right);
    }
}
