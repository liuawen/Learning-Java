package part7tree;

import java.util.ArrayList;

/**
 * 递归的方式依次返回二叉树的前序、中序、后序
 * Created by Dell on 2017-07-26.
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        int[][] res=new int[3][];
        ArrayList<Integer> pre=new ArrayList<Integer>();
        ArrayList<Integer> in=new ArrayList<Integer>();
        ArrayList<Integer> post=new ArrayList<Integer>();
        preOrder(root,pre);
        inOrder(root,in);
        postOrder(root,post);
        res[0]=transeArray(pre);
        res[1]=transeArray(in);
        res[2]=transeArray(post);
        return res;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> pre) {
        if(root!=null){
            pre.add(root.val);
            preOrder(root.left,pre);
            preOrder(root.right,pre);
        }
    }
    private void inOrder(TreeNode root, ArrayList<Integer> in) {
        if(root!=null){
            inOrder(root.left,in);
            in.add(root.val);
            inOrder(root.right,in);
        }
    }
    private void postOrder(TreeNode root, ArrayList<Integer> post) {
        if(root!=null){
            postOrder(root.left,post);

            postOrder(root.right,post);
            post.add(root.val);
        }
    }
    private int[] transeArray(ArrayList<Integer> list){
        int[] res=new int[list.size()];
        int count=0;
        for(Integer i:list){
            res[count++]=i;
        }
        return res;
    }
}
