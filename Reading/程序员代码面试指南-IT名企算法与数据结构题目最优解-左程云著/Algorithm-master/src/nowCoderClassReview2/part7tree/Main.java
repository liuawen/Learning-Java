package part7tree;

/**
 * Created by Dell on 2017-07-27.
 */
public class Main {
    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(5);
        a.left=b;
        a.right=c;
        b.right=d;
        c.left=e;
        int[][] res=new TreePrinter().printTree(a);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                System.out.println(i+"  "+j+"    : "+res[i][j]);
            }
        }

    }
}
