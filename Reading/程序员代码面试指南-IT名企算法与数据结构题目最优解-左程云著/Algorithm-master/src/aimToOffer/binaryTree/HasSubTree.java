package binaryTree;

/**
 * Created by Dell on 2017-06-09.
 */
public class HasSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null)
            return false;
        boolean l=false,r=false;
        if(root1.val==root2.val){
            if(isSubTree(root1,root2)){
                return true;
            }else {
                if(HasSubtree(root1.left, root2)){
                    return true;
                }
                if(HasSubtree(root1.right,root2))
                    return true;
            }
        }
        return false;
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        boolean l=false,r=false;
        if(root2.left!=null){
            if(root1.left!=null){
                //判断其left是否相同
                if(root1.left.val==root2.left.val){
                    l=isSubTree(root1.left,root2.left);
                }else{
                    return false;
                }
            }else{
                //判断为false
                return false;
            }
        }else{
            //左边可以判定为true；
            l=true;
        }
        if(root2.right!=null){
            if(root1.right!=null){
                //判断其left是否相同
                if(root1.right.val==root2.right.val){
                    r=isSubTree(root1.right,root2.right);
                }else{
                    return false;
                }
            }else{
                ////判断为false
                return false;
            }
        }else{
            r=true;
        }
        return l&&r;
    }
}
