package binaryTree;

/**
 * Created by Dell on 2017-06-08.
 */
public class Main {
    public static void main(String[] args){
//        int[] a={5,6,7,9,3,10,8};
//        boolean res=new PostOrder().VerifySquenceOfBST(a);
//        System.out.println(res);
        TreeNode a=new TreeNode(3);
        TreeNode b=new TreeNode(5);
        TreeNode c=new TreeNode(6);
        TreeNode d=new TreeNode(7);
        TreeNode e=new TreeNode(8);
        TreeNode f=new TreeNode(9);
        TreeNode g=new TreeNode(11);
        d.left=b;
        d.right=f;
        f.left=e;
        f.right=g;
        b.left=a;
        b.right=c;
//        new IteratorTree().postOrder(d);
        TreeNode res=new SearchTreeFindK().KthNode(d,5);
        if(res!=null){
            System.out.println("not null     "+res.val);
        }else{
            System.out.println("null");
        }
//        a.left=b;
//        a.right=c;
//        b.left=d;
//        b.right=e;
//        c.left=f;
//        c.right=g;
//        ArrayList<ArrayList<Integer>> res=new PrintSShape().Print(a);
//        for(ArrayList<Integer> list:res){
//            System.out.println();
//            for(Integer num:list){
//                System.out.print("     "+num);
//            }
//        }
//        System.out.println(res);
//        TreeNode front=c;
//        TreeNode pre=null;
//        while(front!=null){
//            System.out.print("      "+front.val);
//            pre=front;
//            front=front.right;
//        }
//        while(pre!=null){
//            System.out.print("      "+pre.val);
//            pre=pre.left;
//        }

//        ArrayList<ArrayList<Integer>> res=new PathSum().FindPath(a,22);
//        for (ArrayList<Integer> list:res) {
//            System.out.println();
//            for(Integer i:list){
//                System.out.print(i+"      ");
//            }
//        }
//        System.out.println(res);
    }
}
