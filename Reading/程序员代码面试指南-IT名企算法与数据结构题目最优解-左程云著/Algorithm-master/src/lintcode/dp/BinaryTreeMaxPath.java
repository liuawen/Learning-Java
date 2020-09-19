package lintcode.dp;

/**
 * Created by Dell on 2017-08-30.
 */
public class BinaryTreeMaxPath {
    //TODO 二叉树最大路径
    public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
    public int maxPathSum(TreeNode root) {
        // write your code here
        int[] res=new int[1];
        res[0]=Integer.MIN_VALUE;
        postTraverse(root,res);
        return res[0];
    }
    //后续遍历，统计的方式，先写后序遍历
    public int postTraverse(TreeNode root,int[] res){
        if(root==null)
            return 0;//0不会影响和的结果
        int l=postTraverse(root.left,res);
        int r=postTraverse(root.right,res);
        res[0]=Math.max(res[0],Math.max(0,l)+Math.max(0,r)+root.val);
        return Math.max(0,Math.max(l,r))+root.val;
    }
}
