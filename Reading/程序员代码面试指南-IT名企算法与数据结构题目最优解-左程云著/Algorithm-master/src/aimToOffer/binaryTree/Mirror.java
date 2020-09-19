package binaryTree;

/**
 * 一颗树变为一棵树的镜像
 * Created by Dell on 2017-06-09.
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        //根不变，将树的左和右交换
        if(root==null)
            return;
        if(root.left!=null||root.right!=null){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            Mirror(root.left);
            Mirror(root.right);
        }
        return;
    }
}
