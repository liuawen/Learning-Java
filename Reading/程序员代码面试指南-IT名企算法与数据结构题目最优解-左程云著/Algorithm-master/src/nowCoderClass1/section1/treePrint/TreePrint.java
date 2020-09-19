package nowCoderClass1.section1.treePrint;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *

 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。

 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。

 * Created by Dell on 2017-04-13.
 */
public class TreePrint {
    public int[][] printTree(TreeNode root) {
        if(root==null) return null;
        TreeNode node=root;
        int last=root.val;
        int nlast=root.val;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> llist=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();

        queue.offer(node);
        while(!queue.isEmpty()){
            node=queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
                nlast=node.left.val;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nlast=node.right.val;
            }
            if(node.val==last){
                llist.add(list);
                list=new ArrayList<Integer>();
                last=nlast;
            }
        }

        int[][] arr=new int[llist.size()][];
        for(int i=0;i<llist.size();i++){
            arr[i]=new int[llist.get(i).size()];
            for(int k=0;k<arr[i].length;k++){
                arr[i][k]=llist.get(i).get(k);
            }
        }
        return arr;
    }
}
