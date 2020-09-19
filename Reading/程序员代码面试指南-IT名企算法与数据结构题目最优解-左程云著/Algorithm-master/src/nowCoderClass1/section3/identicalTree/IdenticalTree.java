package nowCoderClass1.section3.identicalTree;

/**
 * Created by Dell on 2017-05-07.
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */
public class IdenticalTree {
    /**
     * 使用传统的遍历二叉树加比较为O(m*n)
     * 将树的拓扑结构转换成字符串（选择合适的遍历顺序（必须是先序）），再用KMP算法判断是否包含即可
     * @param A
     * @param B
     * @return
     */
    public boolean chkIdentical(TreeNode A, TreeNode B) {
//        preOrder(A);
        String astr=preOrderSerialization(A);
        String bstr=preOrderSerialization(B);
        return astr.contains(bstr);//以后可使用KMP算法优化
    }
    /**
     * 先序序列化，如果遇到空节点，在str末尾加上#!,#表示，!表示一个节点的值的结束
     */
        private String preOrderSerialization(TreeNode root){
            StringBuilder str=new StringBuilder();
        if(root!=null){
            //根
            str.append(root.val+"!");
            //左
            str.append(preOrderSerialization(root.left));
            //右
            str.append(preOrderSerialization(root.right));
        }else{
            str.append("#!");
        }
        return str.toString();
    }

    /**
     * 先写一个先序遍历的方法，再写一个先序序列化的方法
     */
//    private void preOrder(TreeNode root){
//
//        if(root!=null){
//            //根
//            System.out.println(root.val);
//            //左
//            preOrder(root.left);
//            //右
//            preOrder(root.right);
//        }
//    }
}