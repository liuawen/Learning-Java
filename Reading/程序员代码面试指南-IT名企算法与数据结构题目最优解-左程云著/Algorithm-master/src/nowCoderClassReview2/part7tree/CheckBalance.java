package part7tree;

/**
 * Created by Dell on 2017-07-27.
 */
public class CheckBalance {
    public boolean check(TreeNode root) {
        if(root==null)
            return true;
        boolean[] res={true};
        getHeight(root,res);
        return res[0];
    }
    public int getHeight(TreeNode root,boolean[] res){
        if(root==null)
            return 0;
        int lH=getHeight(root.left,res);
        int rH=getHeight(root.right,res);
        if(Math.abs(lH-rH)>1){
            res[0]=false;
        }
        return Math.max(lH,rH)+1;
    }
}
