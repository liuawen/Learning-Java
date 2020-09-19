package lintcode.binaryTree.medium;

import lintcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017-09-01.
 */
public class LevelOrderTraversal {
    //逆序层次遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        if(root!=null) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list.add(root);
            level(list, lists);
        }
        return lists;
    }
    public void level(ArrayList<TreeNode> list, List<List<Integer>> lists){
        if(list.size()==0){
            return;
        }
        ArrayList<TreeNode> nextList=new ArrayList<TreeNode>();
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(TreeNode node:list){
            res.add(node.val);
            if(node.left!=null){
                nextList.add(node.left);
            }
            if(node.right!=null){
                nextList.add(node.right);
            }
        }
        level(nextList,lists);
        lists.add(res);
    }
}
