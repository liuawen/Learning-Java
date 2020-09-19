package lintcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017-09-02.
 */
public class SearchRange {
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        postOrder(root,k1,k2,list);
        return list;
    }
    void postOrder(TreeNode root, int k1, int k2, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        postOrder(root.left,k1,k2,list);
        if(root.val>=k1&&root.val<=k2){
            list.add(root.val);
        }
        postOrder(root.right,k1,k2,list);
    }
}
