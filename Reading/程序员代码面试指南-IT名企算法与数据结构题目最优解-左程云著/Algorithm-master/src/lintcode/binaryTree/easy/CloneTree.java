package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2017-09-01.
 */
public class CloneTree {
    public TreeNode cloneTree(TreeNode root) {//递归深度克隆,耗时1159
        if(root==null){
            return null;
        }
        TreeNode newRoot=new TreeNode(root.val);
        newRoot.left=cloneTree(root.left);
        newRoot.right=cloneTree(root.right);
        return newRoot;
    }
    public TreeNode cloneTree1(TreeNode root) {//宽度克隆，耗时2145
        // Write your code here
        Map<TreeNode,TreeNode> map=new HashMap<TreeNode,TreeNode>();
        copyNode(root,map);
        copyRefer(root,map);
        return map.get(root);
    }
    void copyNode(TreeNode root,Map<TreeNode,TreeNode> map){
        if(root==null){
            return;
        }
        map.put(root,new TreeNode(root.val));
        copyNode(root.left,map);
        copyNode(root.right,map);
    }
    void copyRefer(TreeNode root,Map<TreeNode,TreeNode> map){
        if(root==null){
            return;
        }
        TreeNode node=map.get(root);
        node.left=map.get(root.left);
        node.right=map.get(root.right);
        copyRefer(root.left,map);
        copyRefer(root.right,map);
    }


}
