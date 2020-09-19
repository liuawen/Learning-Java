package binaryTree;

/**
 * Created by Dell on 2017-06-23.
 */
public class IteratorTree
{
    public void preOrder(TreeNode root){
        if(root==null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(TreeNode root){
        if(root==null)
            return;
        if(root.left!=null)
            inOrder(root.left);
        System.out.println(root.val);
        if(root.right!=null)
            inOrder(root.right);
    }
    public void postOrder(TreeNode root){
        if(root==null)
            return;
        if(root.left!=null)
            postOrder(root.left);
        if(root.right!=null)
            postOrder(root.right);
        System.out.println(root.val);

    }
}
