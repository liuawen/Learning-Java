package nowCoderClass1.section6;

/**
 *

 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 给定树的根结点root，请返回树的大小。
 * Created by Dell on 2017-05-13.
 */
public class CountNodes {
    /**
     * 算法思想，先根据root左孩子的最左节点判断这棵树的高度，然后再根据根的右孩子的情况判断左树是否满二叉树，如果是，统计左边的个数，再按照同样的方法统计右边
     * @param root
     * @return
     */
    public int count(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=0;
        int lHeight=0;
        TreeNode current=root.left;
        while(current!=null){
            current=current.left;
            lHeight++;
        }
        //统计出高度,然后判断右边的高度
        int rHeight=0;
        current=root.right;
        while (current!=null){
            current=current.left;
            rHeight++;
        }
        //左子树满，height为1
        if(lHeight==rHeight){
            //左子树为满二叉树，统计左边的个数
            count=(int)Math.pow(2,lHeight);//root和root的左子树
        }else{
            //左子树不满，统计左边的个数
            count=1;
            count+=count(root.left);
        }
        count+=count(root.right);
        return count;
    }
}
