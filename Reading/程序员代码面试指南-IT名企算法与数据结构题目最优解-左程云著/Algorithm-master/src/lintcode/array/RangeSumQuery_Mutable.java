package lintcode.array;

/**
 * Created by Dell on 2017-09-01.
 */
public class RangeSumQuery_Mutable {

    /**
     * 区域和检索，可变
     * 树状数组BinaryIndexedTree    查询和修改都为O(logn)
     */
    private int[] num;
    private int[] bit;
    public RangeSumQuery_Mutable(int[] matrix) {
        num=new int[matrix.length+1];
        bit=new int[matrix.length+1];
        for(int i=0;i<matrix.length;i++){
            update(i,matrix[i]);
        }
    }
    public void update(int i,int val){
        int diff=val-num[i+1];
        for (int j=i+1;j<num.length;j+=(j&-j)){
            bit[j]+=diff;
        }
        num[i+1]=val;
    }
    public int sumRange(int i, int j) {
        return getSum(j+1)-getSum(i);
    }
    public int getSum(int i){
        int res=0;
        for(int j=i;j>0;j-=(j&-j)){
            res+=bit[j];
        }
        return res;
    }
}
