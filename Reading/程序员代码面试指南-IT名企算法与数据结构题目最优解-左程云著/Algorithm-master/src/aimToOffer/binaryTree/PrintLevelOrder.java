package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Dell on 2017-06-09.
 */
public class PrintLevelOrder {
    /**
     * 层序遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        TreeNode current=null;
        while(!queue.isEmpty()){
            current=queue.remove();
            list.add(current.val);
            if(current.left!=null){
                queue.add(current.left);
//                deque.
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
        return list;
    }
}
