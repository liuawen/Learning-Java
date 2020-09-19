package lintcode.binaryTree.easy;

import lintcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017-09-01.
 */
public class Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<String>();
        pathHelp(root,res,new ArrayList<Integer>());
        return res;
    }
    public void pathHelp(TreeNode root,List<String> res,ArrayList<Integer> list){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            list.add(root.val);
            res.add(print(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        pathHelp(root.left,res,list);
        pathHelp(root.right,res,list);
        list.remove(list.size()-1);
    }

    private String print(ArrayList<Integer> list) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size()-1;i++){
            sb.append(list.get(i)+"->");
        }
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }
}
