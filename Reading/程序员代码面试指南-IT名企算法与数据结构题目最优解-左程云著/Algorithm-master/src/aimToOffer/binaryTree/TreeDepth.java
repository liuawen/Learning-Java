package binaryTree;

/**
 * Created by Dell on 2017-06-13.
 */
public class TreeDepth {
    /**
     * 求树的深度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=1+TreeDepth(root.left);
        int right=1+TreeDepth(root.right);
        return left>right?left:right;
    }
}
