package nowCoderClass1.sorted;

/**
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * Created by Dell on 2017-05-07.
 */
public class Gap{
    /**
     * 利用桶排序的思想，遍历一遍将最大值和最小值记录下来，
     * 设置n个桶，每个桶的元素区间为最小值和最大值的差除以n+最小值，这样元素就会分散在桶中，元素都是整数，中间必然会出现空桶，计算最大空桶的间距
     * @param A
     * @param n
     * @return
     */
        public int maxGap(int[] A, int n) {
            //利用桶排序的思想，遍历一遍将最大值和最小值记录下来，
            int min=A[0],max=A[0];
            for(int i=1;i<n;i++){
                if(A[i]>max){
                    max=A[i];
                }
                if(A[i]<min){
                    min=A[i];
                }
            }
//            @Todo
            //设置n+1个桶，最后一个桶存放最大值
//            ArrayList



            return 0;
        }
}
