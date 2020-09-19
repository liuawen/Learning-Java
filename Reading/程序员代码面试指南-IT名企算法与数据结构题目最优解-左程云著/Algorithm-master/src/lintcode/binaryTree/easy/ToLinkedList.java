package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class ToLinkedList {
    //按照前序遍历，转换成链表
    public void flatten(TreeNode root) {
        // write your code here
        convertToLink(root);
    }
    public TreeNode convertToLink(TreeNode root){
        if(root==null)
            return null;
        TreeNode leftLinkTail=convertToLink(root.left);
        TreeNode rightLinkTail=convertToLink(root.right);
        if(leftLinkTail!=null){
            leftLinkTail.right=root.right;
            root.right=root.left;
        }
        root.left=null;
        if(rightLinkTail!=null){
            return rightLinkTail;
        }else if (leftLinkTail!=null){
            return leftLinkTail;
        }else
            return root;
    }

}
