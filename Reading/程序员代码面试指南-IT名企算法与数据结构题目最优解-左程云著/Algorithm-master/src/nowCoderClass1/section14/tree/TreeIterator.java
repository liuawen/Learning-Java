package nowCoderClass1.section14.tree;

/**
 *
 * Created by Dell on 2017-06-20.
 */
public class TreeIterator {
    public void preOrder(TreeNode root){
        if(root!=null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

}
