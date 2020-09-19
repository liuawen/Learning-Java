package binaryTree;

/**
 * Created by Dell on 2017-06-13.
 */
public class IsBalanceTree {
    /**
     * 判断是否是平衡二叉树，用递归的方式分别统计左子树和右子树的高度，一旦发现相差大于2，返回false
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        boolean[] res=new boolean[1];
        res[0]=true;
        getHeight(root,0,res);
        return res[0];
    }

    /**
     * 用res和level来保存高度和结果
     * @param root
     * @param res
     * @return
     */
    public int getHeight(TreeNode root,int level, boolean[] res){
        if(root==null)
            return level;
        int lH=getHeight(root.left,level+1,res);
        if(!res[0]){
            return level;
        }
        int rH=getHeight(root.right,level+1,res);
        if(!res[0]){
            return level;
        }
        if(Math.abs(lH-rH)>1)
            res[0]=false;
        return Math.max(lH,rH);
    }

}
