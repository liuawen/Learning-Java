package lintcode.binaryTree.medium;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-02.
 */
public class BuildTree {
    //如果用前序和中序构造二叉树，前序直接就能找到根，在中序中根的左边是左子树，右边是右子树

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return help(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode help(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if(postBegin>postEnd){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int rootIndex=-1;
        for (int i=inBegin;i<=inEnd;i++){
            if(inorder[i]==postorder[postEnd]){
                rootIndex=i;
                break;
            }
        }
        int len=rootIndex-1-inBegin;//求in左侧的长度

        root.left=help(inorder,inBegin,rootIndex-1,postorder,postBegin,postBegin+len);
        root.right=help(inorder,rootIndex+1,inEnd,postorder,postBegin+len+1,postEnd-1);
        return root;
    }
//    public TreeNode help(int[] inor)

}
