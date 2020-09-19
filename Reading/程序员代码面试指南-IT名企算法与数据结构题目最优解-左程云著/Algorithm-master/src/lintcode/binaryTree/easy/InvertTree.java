package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class InvertTree {
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root==null){
            return;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
