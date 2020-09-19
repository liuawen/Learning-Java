package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class IdenticalTree {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        return preCheck(a,b);
    }

    private boolean preCheck(TreeNode a, TreeNode b) {
        if(a!=null&&b!=null){
            if(a.val==b.val){
                boolean left=preCheck(a.left,b.left);
                boolean right=preCheck(a.right,b.right);
                return left&&right;
            }else
                return false;
        }
        return a==b;//可能一个为空，一个不为空，也可能都为空

    }
}
