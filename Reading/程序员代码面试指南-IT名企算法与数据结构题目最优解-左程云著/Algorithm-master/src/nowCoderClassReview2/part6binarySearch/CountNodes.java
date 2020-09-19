package part6binarySearch;

/**
 * Created by Dell on 2017-07-26.
 */
public class CountNodes {

    public int count(TreeNode root) {
        if(root!=null){
            int count=1;
            int leftH=0,rightH=0;
            TreeNode cur=root.left;
            while(cur!=null){//统计最左节点的高度
                leftH++;
                cur=cur.left;
            }
            cur=root.right;
            while(cur!=null){//统计最左节点的高度
                rightH++;
                cur=cur.right;
            }
            if(leftH==rightH){
                count+=Math.pow(2,leftH)-1;
                count+=count(root.right);
            }else{
                count+=count(root.left);
                count+=count(root.right);
            }
            return count;
        }
        return 0;
    }
}
