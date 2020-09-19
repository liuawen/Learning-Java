package nowCoderClass1.sorted;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。

 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 * Created by Dell on 2017-05-07.
 */
public class Subsequence {
    /**
     * 从前扫描一遍，记录下最后一个无序的位置，从后扫描一遍，记录下最前面的无序位置，返回这两个数之间的元素个数
     * @param A
     * @param n
     * @return
     */
    public int shortestSubsequence(int[] A, int n) {
        if(A==null||n==1||n==0){
            return 0;
        }
        // 这道题是有隐含前提的，是从小到大
        int right=0;
        int left=0;
        //从前往后扫，需要记录下最大值，如比最大值小，说明无序，无序则将下标赋值给right
        int max=A[0];
        for(int i=1;i<n;i++){
            if(A[i]<max){
                right=i;
            }else{
                max=A[i];
            }
        }
        //从后往前扫，需要记录下最小值，如比最小值大，说明无序，无序则将下标赋值给left
        int min=A[n-1];
        for(int i=n-2;i>=0;i--){
            if(A[i]>min){
                left=i;
            }else{
                min=A[i];
            }
        }
        if(left==0&&right==0)
            return 0;
        return right-left+1;
    }
}
