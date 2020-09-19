package lintcode.binaryTree.medium;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-02.
 */
public class LCA {
    //最近公共祖先节点，先找两个节点的路径，放在list中，倒序遍历，找出第一个相同的
    //使用递归的方式，一旦找到返回true，一旦发现某个地方A，B同时weitrue，该节点就是第一个公共祖先节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if(root==null||root==A||root==B){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,A,B);
        TreeNode right=lowestCommonAncestor(root.right,A,B);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;
    }
}
