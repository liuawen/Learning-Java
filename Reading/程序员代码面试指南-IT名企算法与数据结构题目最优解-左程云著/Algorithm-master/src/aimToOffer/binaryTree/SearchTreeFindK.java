package binaryTree;

/**
 * Created by Dell on 2017-06-21.
 */
public class SearchTreeFindK {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<=0)
            return null;
        TreeNode[] res=new TreeNode[1];
        inOrder(pRoot,new int[]{0},k,res);
        return res[0];
    }
    /**
     * 中序遍历
     */
    void inOrder(TreeNode root,int[] count,int k,TreeNode[] res){
            if(root.left!=null)
                inOrder(root.left,count,k,res);
            //访问root
            count[0]++;
            if(count[0]==k){
                res[0]=root;
                return;
            }else{
                if(root.right!=null)
                    inOrder(root.right,count,k,res);
            }
    }

}
