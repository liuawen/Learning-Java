package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dell on 2017-09-01.
 */
public class LevelTraverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        if(root==null)
            return lists;
        ArrayList<Integer> list=new ArrayList<Integer>();
        //队列
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        //用right和nextRight来区分层
        TreeNode right=root;
        TreeNode nextRight=null;
        TreeNode cur=null;
        queue.add(root);
        while (!queue.isEmpty()){
            cur=queue.pop();
            //将cur的孩子入队列
            if(cur.left!=null){
                queue.add(cur.left);
                nextRight=cur.left;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                nextRight=cur.right;
            }
            list.add(cur.val);
            if(cur==right){
                //标志着一层的结束
                lists.add(list);
                list=new ArrayList<Integer>();
                right=nextRight;
            }
        }
        return lists;
    }
}
