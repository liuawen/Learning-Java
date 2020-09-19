package part3str;



/**
 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树
 * Created by Dell on 2017-07-23.
 */
public class IdenticalTree {
    public StringBuilder sb=new StringBuilder();
    //先将两棵树都序列化，判断是否包含
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        serializable(A);
        String a=sb.toString();
        sb.setLength(0);
        serializable(B);
        String b=sb.toString();
        return a.contains(b);
    }
    //序列化树,一个节点数字结束，使用！空使用#
    public void serializable(TreeNode A){
        if(A!=null){
            sb.append(A.val+"!");
            serializable(A.left);
            serializable(A.right);
        }else {
            sb.append("!#");
        }
    }
}
