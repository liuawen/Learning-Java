package array;

/**
 * Created by Dell on 2017-06-11.
 */
public class FindGreatestSumOfSubArray {
    /*
    从头开始去掉和为负的，从后开始去掉和为负的，递归，逐步缩小范围。
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;
        int index=1;
        int maxSum=array[0],sum=array[0];
        while(index<array.length){
            if(sum<0)
                sum=array[index];
            else
                sum+=array[index];
            if(sum>maxSum)
                maxSum=sum;
            index++;
        }
        return maxSum;
    }
//    public boolean isPositive(int[] array,int begin,int sum)
}
