package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-01.
 */
public class ConvertArrayToBST {

    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        return help(A,0,A.length-1);
    }
    public TreeNode help(int[] A,int begin,int end){
        if(begin<=end){
            int mid=(begin+end)/2;
            TreeNode root=new TreeNode(A[mid]);
            root.left=help(A,begin,mid-1);
            root.right=help(A,mid+1,end);
            return root;
        }else{
            return null;
        }
    }
}
