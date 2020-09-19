package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class ConvertBSTToGreaterTree {
    //BST 二叉搜索树
    public TreeNode convertBST(TreeNode root) {
        //先右--根--左，
        convert(root,0);
        return root;
    }
    //返回值是前一个节点
    void convert(TreeNode root,int sum){
        if(root==null){
            return;
        }
        convert(root.right,sum);
        root.val+=sum;
        sum=root.val;
        convert(root.left,sum);
    }
}
