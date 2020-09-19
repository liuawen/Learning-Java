package lintcode.binaryTree.medium.segmentTree;

/**
 * Created by Dell on 2017-09-02.
 */
public class SegmentTree {
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start>end){
            return null;
        }
        SegmentTreeNode root=new SegmentTreeNode(start,end);
        if(start<end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        return root;
    }
    /*
        对于最大线段树，根据给出的index的区间，max调整为value，其所在路径的max都要更新     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start==root.end&&root.end==index){
            root.max=value;
            return;
        }
        int mid=(root.start+root.end)/2;
        if(index<=mid){
            modify(root.left,index,value);
            root.max= Math.max(root.left.max,root.right.max);
        }else{
            modify(root.right,index,value);
            root.max= Math.max(root.left.max,root.right.max);
        }
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if(root.start==start&&root.end==end){
            return root.max;
        }
        int mid=(root.start+root.end)/2;
        if(end<=mid){//左边
            return query(root.left,start,end);
        }else if(start>mid){//右边
            return query(root.right,start,end);
        }else{//查询的区间一部分在左，一部分在右
            int left=query(root.left,start,mid);
            int right=query(root.right,mid+1,end);
            return Math.max(left,right);
        }
    }
//    public int queryII(SegmentTreeNode root, int start, int end) {
//        if(root.start==start&&root.end==end){
//            return root.count;
//        }
//        int mid=(root.start+root.end)/2;
//        if(end<=mid){//左边
//            return query(root.left,start,end);
//        }else if(start>mid){//右边
//            return query(root.right,start,end);
//        }else{//查询的区间一部分在左，一部分在右
//            int left=query(root.left,start,mid);
//            int right=query(root.right,mid+1,end);
//            return left+right;
//        }
//    }

}
