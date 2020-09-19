package binaryTree;

/**
 * Created by Dell on 2017-06-08.
 */
public class RebuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }
        return rebuildTree(pre,0,in,0,in.length-1);
    }
    public TreeNode rebuildTree(int[]pre,int preBegin,int[] in,int begin,int end){
        TreeNode root=new TreeNode(pre[preBegin]);
        if((end-begin)>1){//保证元素至少有两个
            //根据preBegin选根，查找根所在位置的下标
            int rootIndex=pos(pre[preBegin],in,begin,end);
            //左递归
            System.out.println("rootIndex   "+rootIndex+"    begin   "+begin+"   end    "+(rootIndex-1));
            if(begin<=rootIndex-1){
                root.left=rebuildTree(pre,preBegin+1,in,begin,rootIndex-1);
            }

            //右递归
            System.out.println("rootIndex   "+rootIndex+"    begin   "+(rootIndex+1)+"   end    "+end);
            if(rootIndex+1<=end){
                root.right=rebuildTree(pre,preBegin+1+rootIndex-begin,in,rootIndex+1,end);
            }
        }else{
            //少于两个值，将这两个值也添加到树中
            if(end-begin==1){
                //应该判断root在in中靠近begin还是end，判断是左子树还是右子树
                int rootIndex=pos(pre[preBegin],in,begin,end);
                if(rootIndex==begin){
                    root.right=new TreeNode(pre[preBegin+1]);
                }else{
                    root.left=new TreeNode(pre[preBegin+1]);
                }
            }

        }
        return root;
    }
    public int pos(int aim,int[] in,int small,int big) {
        for (int i = small; i <= big; i++)
            if (in[i] == aim)
                return i;
        return -1;
    }

    public void preOrder(TreeNode root){
        if(root!=null){
            System.out.println(root+"     "+root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
