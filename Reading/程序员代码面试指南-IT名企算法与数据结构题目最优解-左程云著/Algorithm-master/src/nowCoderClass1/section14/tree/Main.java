package nowCoderClass1.section14.tree;

import java.util.Arrays;

/**
 * Created by Dell on 2017-06-20.
 */
public class Main {
    public static void main(String[] args){
        String[] as=new FoldPaper().foldPaper(3);
                Arrays.stream(as).forEach(i->System.out.println(i));

        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(5);
        a.left=b;
        b.left=c;
        a.right=d;
        d.right=e;
//        int[] ff=new TreeToSequence().preOrder(a);
//        Arrays.stream(ff).forEach(i->System.out.println(i));

//        int[] ss=new TreeToSequence().postOrder(a);
//        Arrays.stream(ss).forEach(i->System.out.println("sssss   "+i));
    }
}
