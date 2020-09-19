package part7tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dell on 2017-07-27.
 */
public class CheckCompletion {

    public class A{

    }

    //检查是否是完全二叉树，只需要层序遍历即可
    public boolean chk(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode cur=null;
        boolean flag=false;//标志是否出现节点不全的情况，true为出现，后面的节点必须全为叶节点
        //检查的过程中检查每个节点子节点的情况，一旦发现一个节点不是两个节点全有，就修改flag
        while (!queue.isEmpty()){
            cur=queue.poll();

            if(flag){
                if(cur.left!=null||cur.right!=null){
                    return false;
                }
            }else{
                if((cur.left==null&&cur.right==null)||(cur.left!=null&&cur.right==null)){
                    //出现为空
                    flag=true;
                }else if(cur.left!=null&&cur.right!=null){
                    queue.add(cur.left);
                    queue.add(cur.right);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
