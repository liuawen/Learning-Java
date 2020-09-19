package binaryTree;

/**
 * Created by Dell on 2017-06-21.
 */
public class Serialize {
    int index=-1;
    //先序，序列化树, ，作为两个节点之间的分隔符，#作为空节点
    String Serialize(TreeNode root) {
        if(root==null)
            return "#!";
        else{
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(root.val+"!");
            stringBuilder.append(Serialize(root.left));
            stringBuilder.append(Serialize(root.right));
            return stringBuilder.toString();
        }
    }

    TreeNode Deserialize(String str) {
        TreeNode root=null,cur=null;
        String[] s=str.split("!");
        index++;
            if(!s[index].equals("#")){
                //转成数字
                root=new TreeNode(Integer.parseInt(s[index]));
                root.left=Deserialize(str);
                root.right=Deserialize(str);
            }
        return root;
    }
}
