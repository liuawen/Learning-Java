package codingInterviewGuide.part2Linked;

/**
 * Created by Dell on 2017-08-05.
 */
public class ConvertTreeToLinked {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        inOrder(pRootOfTree,null);
        TreeNode c=pRootOfTree;
        while(c.left!=null){
            c=c.left;
        }
        return c;
    }

    /**
     *  思路是中序遍历，
     * @param root   保证root不为空
     * @param pre   相当于是该树的前序
     */
    public TreeNode inOrder(TreeNode root,TreeNode pre){
        //左节点不空
        if(root.left!=null)
            pre=inOrder(root.left,pre);
        if(pre!=null){
            pre.right=root;
            root.left=pre;
            pre=root;
        }
        if(root.left==null&&pre==null){//这是最左节点
            pre=root;
        }
        if(root.right!=null){
            pre=inOrder(root.right,pre);
        }
        return pre;
    }
}
