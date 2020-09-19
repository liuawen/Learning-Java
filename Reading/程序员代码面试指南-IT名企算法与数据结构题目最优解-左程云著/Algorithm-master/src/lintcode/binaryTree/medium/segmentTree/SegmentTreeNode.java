package lintcode.binaryTree.medium.segmentTree;

/**
 * Created by Dell on 2017-09-02.
 */
public class SegmentTreeNode {
    public int start,end,max;
    public SegmentTreeNode left,right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }
    public SegmentTreeNode(int start, int end,int max) {
        this(start,end);
        this.max=max;
    }

}
