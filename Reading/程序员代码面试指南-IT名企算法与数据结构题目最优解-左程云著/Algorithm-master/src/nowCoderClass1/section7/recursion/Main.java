package nowCoderClass1.section7.recursion;


/**
 * Created by Dell on 2017-05-24.
 */
public class Main {
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
        TreeToSequence s=new TreeToSequence();
        int[][] res=s.convert(a);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print("      "+res[i][j]);
            }
            System.out.println();
        }
    }
}
