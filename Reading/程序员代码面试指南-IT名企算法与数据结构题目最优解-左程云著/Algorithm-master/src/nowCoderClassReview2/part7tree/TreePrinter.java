package part7tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dell on 2017-07-27.
 */
public class TreePrinter {
    //层次打印，每一行存一个数组
    public int[][] printTree(TreeNode root) {
        if(root==null)
            return null;
        Queue<TreeNode> stack=new LinkedList<TreeNode>() ;
        stack.add(root);
        ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
        //记录下最右的结点
        TreeNode last=root,right=null,cur=null;//last是本层的最右，right是更新统计下一层的最右
        ArrayList<Integer> curlist=null;
        while(!stack.isEmpty()){//什么时候判断是否最右
            cur=stack.poll();
            //添加到对应的curlist中
            if(curlist==null){
                curlist=new ArrayList<Integer>();
            }
            curlist.add(cur.val);
            //将该节点的子节点添加到Stack中，并维护right的值
            if(cur.left!=null){
                stack.add(cur.left);
                right=cur.left;
            }
            if(cur.right!=null){
                stack.add(cur.right);
                right=cur.right;
            }
            //根据last判断curlist的提交和更新，last和right
            if(cur==last){//说明已经到了尾部
                lists.add(curlist);
                curlist=null;
                last=right;
            }
        }
        int[][] res=new int[lists.size()][];
        int i=0,j=0;
        for(ArrayList<Integer> list:lists){
            res[i]=new int[list.size()];
            for(Integer num:list){
                res[i][j++]=num;
            }
            i++;j=0;
        }
        return res;
    }
}
