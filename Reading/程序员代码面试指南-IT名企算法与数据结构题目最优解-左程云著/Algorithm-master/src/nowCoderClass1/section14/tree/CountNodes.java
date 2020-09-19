package nowCoderClass1.section14.tree;

/**
 * 二分统计完全二叉树的个数
 * Created by Dell on 2017-06-20.
 */
public class CountNodes {
    public int count(TreeNode root) {
        if(root==null)
            return 0;
        int count=0,lHeight=0;
        int rHeight=0;
        TreeNode cur=root.left;
        while(cur!=null){
            lHeight++;
            cur=cur.left;
        }
        cur=root.right;
        while(cur!=null){
            rHeight++;
            cur=cur.left;
        }
        if(lHeight==rHeight){//左子树为满二叉树
            count=(int)Math.pow(2,lHeight);
        }else{
            count=1+count(root.left);
        }
        count+=count(root.right);
        return count;
    }
}
