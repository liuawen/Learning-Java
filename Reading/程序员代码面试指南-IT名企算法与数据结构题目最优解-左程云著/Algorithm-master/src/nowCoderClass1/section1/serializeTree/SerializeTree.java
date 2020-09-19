package nowCoderClass1.section1.serializeTree;

import nowCoderClass1.section1.printTreeAndDepth.BinaryTreeNode;

/**
 * Created by Dell on 2017-04-13.
 */
public class SerializeTree {
    public int index = -1;  // 节点在序列中的索引

    /**
     * #号作为结束符
     * ！作为结束符
     * @param root
     * @return
     */
    public String Serialize(BinaryTreeNode<String> root){//先序是根左右
        StringBuffer sb = new StringBuffer();
        if(root==null){
            return "#!";
        }else{
            sb.append(root.element+"!");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
        return sb.toString();
    }
    public BinaryTreeNode deSerialize(String str){
        BinaryTreeNode root=null;
        String[] arr=str.split("!");
        index++;

        if(!(arr[index].equals("#"))){
            root=new BinaryTreeNode(arr[index]);
            root.left=deSerialize(str);
            root.right=deSerialize(str);
        }
        return root;
    }





    /**
     * 序列化
     * 前序遍历，将二叉树节点的值转为字符序列，null转为“#”
     *
     * @param root
     * @return
     */
//    String Serialize(TreeNode root) {
//        StringBuffer s = new StringBuffer();
//        if (root == null) {
//            s.append("#,");
//            return s.toString();
//        }
//        s.append(root.val + ",");
//        s.append(Serialize(root.left));
//        s.append(Serialize(root.right));
//        return s.toString();
//    }

    /**
     * 反序列化
     *
     * @param str
     * @return
     */
//    TreeNode Deserialize(String str) {
//        index++;
//        int length = str.length();
//        if (index >= length) {
//            return null;
//        }
//        String[] nodeSeq = str.split(",");
//        TreeNode pNode = null;
//        if (!nodeSeq[index].equals("#")) {
//            pNode = new TreeNode(Integer.valueOf(nodeSeq[index]));
//            pNode.left = Deserialize(str);
//            pNode.right = Deserialize(str);
//        }
//        return pNode;
//    }
}
