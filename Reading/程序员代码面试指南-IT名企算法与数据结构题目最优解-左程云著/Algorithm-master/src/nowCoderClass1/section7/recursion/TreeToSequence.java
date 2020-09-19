package nowCoderClass1.section7.recursion;
import java.util.ArrayList;

/**
 * 递归的方式依次返回二叉树的前序、中序、后序
 * Created by Dell on 2017-05-24.
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        int[][] res=new int[3][];
        ArrayList<Integer> pre=getPreOrder(root,new ArrayList<Integer>());
        ArrayList<Integer> in=getInOrder(root,new ArrayList<Integer>());
        ArrayList<Integer> post=getPostOrder(root,new ArrayList<Integer>());

        res[0]=toArray(pre);
        res[1]=toArray(in);
        res[2]=toArray(post);
        return res;
    }

    public int[] toArray(ArrayList<Integer> list){
        int[] res=new int[list.size()];
        int count=0;
        for(Integer i:list){
            res[count]=i;
            count++;
        }
        return res;
    }
    public ArrayList<Integer> getPreOrder(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return list;
        }else{
            list.add(root.val);
            getPreOrder(root.left,list);
            getPreOrder(root.right,list);
        }
        return list;
    }
    public ArrayList<Integer> getInOrder(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return list;
        }else{
            getInOrder(root.left,list);
            list.add(root.val);
            getInOrder(root.right,list);
        }
        return list;
    }
    public ArrayList<Integer> getPostOrder(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return list;
        }else{
            getPostOrder(root.left,list);
            getPostOrder(root.right,list);
            list.add(root.val);
        }
        return list;
    }
}
