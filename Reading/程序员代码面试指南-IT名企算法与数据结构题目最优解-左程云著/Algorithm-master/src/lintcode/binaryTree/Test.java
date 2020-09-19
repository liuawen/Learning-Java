package lintcode.binaryTree;

import lintcode.binaryTree.medium.LCA;

/**
 * Created by Dell on 2017-09-01.
 */
public class Test {
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        TreeNode res=new LCA().lowestCommonAncestor(node1,node4,node5);
        System.out.println(res.val);
        TreeNode res1=new LCA().lowestCommonAncestor(node1,node2,node5);
        System.out.println(res1.val);
        TreeNode res2=new LCA().lowestCommonAncestor(node1,node4,node6);
        System.out.println(res2.val);
//        String res=new Serialize().serialize(node1);
//        System.out.println(res);
//        TreeNode root=new Serialize().deserialize(res);
//        boolean equal=new IdenticalTree().isIdentical(root,node1);
//        System.out.println(equal);
//        new LevelOrderTraversal().levelOrderBottom(node1);
//        new ToLinkedList().flatten(node1);
//        new ConvertBSTToGreaterTree().convertBST(node1);

//        int[] A={1,2,3,4,5,6,7};
//        TreeNode root=new ConvertArrayToBST().sortedArrayToBST(A);
//        List<List<Integer>> lists=new LevelTraverse().levelOrder(root);
//        for(List<Integer> list:lists){
//            for(Integer e:list){
//                System.out.print(e+"    ");
//            }
//            System.out.println();
//        }
//        node1.right=node2;
//        int[] a={1,2};
//        int[] b={2,1};
//        new BuildTree().buildTree(a,b);
    }
}
