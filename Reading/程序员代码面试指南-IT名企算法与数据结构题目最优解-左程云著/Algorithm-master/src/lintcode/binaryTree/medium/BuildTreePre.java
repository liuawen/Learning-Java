package lintcode.binaryTree.medium;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-02.
 */
public class BuildTreePre {
    //先序和中序建树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode help(int[] preorder,int preBegin,int preEnd,int[] inorder,int inBegin,int inEnd){
        if(preBegin>preEnd){
            return null;
        }
        int rootIndex=-1;
        for(int i=inBegin;i<=inEnd;i++){
            if(inorder[i]==preorder[preBegin]){
                rootIndex=i;
                break;
            }
        }
        TreeNode root=new TreeNode(preorder[preBegin]);
        int len=rootIndex-1-inBegin;
        root.left=help(preorder,preBegin+1,preBegin+1+len,inorder,inBegin,rootIndex-1);
        root.right=help(preorder,preBegin+1+len+1,preEnd,inorder,rootIndex+1,inEnd);
        return root;
    }
}
