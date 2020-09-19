package lintcode.binaryTree.medium;

import lintcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017-09-02.
 */
public class IsVaildBST {
    List<Integer> list = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        inOrderTraversal(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }

    /*
    因为使用了Integer。MIN_VALUE,所以二叉树中有此点时AC不了
     */
//    public boolean isValidBST(TreeNode root) {
//        // write your code here
//        int[] before=new int[1];
//        before[0]=Integer.MIN_VALUE;
//        return check(root,before);
//    }
//    public boolean check(TreeNode root,int[] before){
//        if(root==null){
//            return true;
//        }
//        boolean left=check(root.left,before);
//        if(!left){return left;}
//        if(root.val<before[0]){
//            return false;
//        }
//
//        before[0]=root.val;
//        boolean right=check(root.right,before);
//        return left&&right;
//    }
}
