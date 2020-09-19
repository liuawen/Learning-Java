package binaryTree;

/**
 * Created by Dell on 2017-06-21.
 */
public class IsSymmetry {
    //判断是不是对称树
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
            return true;
        return isEqual(pRoot.left,pRoot.right);
    }
    /**
     *
     * @param leftRoot
     * @param rightRoot
     * @return
     */
    boolean isEqual(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot==null&&rightRoot==null){
            return true;
        }else {
            if(leftRoot==null||rightRoot==null)
                return false;
            //开始比较左右两边，左右两边均不为空
            if(leftRoot.val==rightRoot.val){
                boolean a=isEqual(leftRoot.left,rightRoot.right);
                if(a==false)
                    return a;
                boolean b=isEqual(leftRoot.right,rightRoot.left);
                return a&&b;
            }else{
                return false;
            }
        }
    }
}
