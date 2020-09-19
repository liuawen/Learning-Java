package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class Subtree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2==null){
            return true;
        }
        if(T1!=null) {
            if (check(T1, T2)) {
                return true;
            }
            boolean left = isSubtree(T1.left, T2);
            boolean right = isSubtree(T1.right, T2);
            return left || right;
        }else {
            return false;
        }
    }
    //依次检查每一个节点
    public boolean check(TreeNode root1,TreeNode root2){
        if(root1!=null&&root2!=null) {
            if(root1.val==root2.val){
                boolean left=check(root1.left,root2.left);
                boolean right=check(root1.right,root2.right);
                return left&&right;
            }
            return false;
        }
        if(root1==null&&root2==null){
            return true;
        }
        return false;
    }
}
