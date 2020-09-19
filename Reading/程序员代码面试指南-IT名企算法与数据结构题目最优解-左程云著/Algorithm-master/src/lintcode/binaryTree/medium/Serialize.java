package lintcode.binaryTree.medium;

import lintcode.binaryTree.TreeNode;

/**
 * Created by Dell on 2017-09-02.
 */
public class Serialize {

    public String serialize(TreeNode root) {
        // write your code here
        if(root==null){
            return "#!";
        }
        StringBuilder sb=new StringBuilder();
        sb.append(root.val+"!");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    int index=-1;//使用全局的计数变量，虽然不太好，但是代码很简洁
    public TreeNode deserialize(String data) {
        String[] arr=data.split("!");
        index++;
        if(arr[index].equals("#")){
            return null;
        }else{
            TreeNode root=new TreeNode(Integer.parseInt(arr[index]));
            root.left=deserialize(data);
            root.right=deserialize(data);
            return root;
        }
    }

//    public String serialize(TreeNode root) {
//        // write your code here
//        StringBuilder sb=new StringBuilder();
//        serializeHelp(root,sb);
//        return sb.toString();
//    }
//    //#空，！一个节点访问结束
//    public void serializeHelp(TreeNode root,StringBuilder sb){
//        if(root==null){
//            sb.append("#!");
//            return;
//        }
//        sb.append(root.val+"!");
//        serializeHelp(root.left,sb);
//        serializeHelp(root.right,sb);
//    }
//    /**
//     * This method will be invoked second, the argument data is what exactly
//     * you serialized at method "serialize", that means the data is not given by
//     * system, it's given by your own serialize method. So the format of data is
//     * designed by yourself, and deserialize it here as you serialize it in
//     * "serialize" method.
//     */
//    public TreeNode deserialize(String data) {
//        // write your code here
//        TreeNode[] root=new TreeNode[1];
//        deserializeHelp(data,root);
//        return root[0];
//    }
//    public String deserializeHelp(String data,TreeNode[] root){
//        int pos=0;
//        while (data.charAt(pos++)!='!');
//        if(data.substring(0,pos).equals("#!")){
//            root=null;
//            return data.substring(pos);
//        }else{
//            root[0]=new TreeNode(Integer.parseInt(data.substring(0,pos-1)));
//            TreeNode[] left=new TreeNode[1];
//            data=deserializeHelp(data.substring(pos),left);
//            root[0].left=left[0];
//            TreeNode[] right=new TreeNode[1];
//            String s= deserializeHelp(data,right);
//            root[0].right=right[0];
//            return s;
//        }
//    }
}
