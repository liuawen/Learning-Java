package nowCoderClass1.section6;

/**对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 给定数组arr及它的大小n，请返回最小值。
 * Created by Dell on 2017-05-12.
 * [4,1,2,3,3],5    使用二分搜索的办法
 */
public class MinValue {
    public int getMin(int[] arr, int n) {
        if(arr==null||n<=0){
            return -1;
        }
        if(n==1||arr[0]<arr[n-1])
            return arr[0];
        //最小值在1-n-1之间,使用二分法,去找最低的位置
        search(arr,1,n-1);
        return 1;
    }

    private int search(int[] arr, int left, int right) {
        if(left<=right){
            int mid=(left+right)/2;
            if(left>mid&&right>mid){//左边大于，右边也大于
                search(arr,left+1,mid);
            }else{
                if(left<mid&&right<mid){//两边都小
                    search(arr,left,right);
                }
            }
        }
        return -1;
    }
}
