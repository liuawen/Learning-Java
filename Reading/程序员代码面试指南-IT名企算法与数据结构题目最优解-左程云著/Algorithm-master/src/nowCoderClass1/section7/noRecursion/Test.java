package nowCoderClass1.section7.noRecursion;

/**
 *
 * Created by Dell on 2017-05-12.
 */
public class Test {
    public static void main(String[] args){
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(5);
        TreeNode f=new TreeNode(6);
        TreeNode g=new TreeNode(7);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        e.left=g;

        int[] arr=new TreeToSequence().inOrder(a);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
