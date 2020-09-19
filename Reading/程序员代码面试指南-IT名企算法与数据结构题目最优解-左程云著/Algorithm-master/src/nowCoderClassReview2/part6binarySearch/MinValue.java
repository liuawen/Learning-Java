package part6binarySearch;

/**
 * 有序循环数组，[4,1,2,3,3]也是。
 给定数组arr及它的大小n，请返回最小值。
 二分搜索可用来缩小查找的范围
 * Created by Dell on 2017-07-24.
 */
public class MinValue {
    //利用循环过的左和右，还有中间的数来判断，如果整体升序，则有序，
    // 如果左大右小，则在中间会有最小值，如果两者相等，则两边都有可能出现最小值
    public int getMin(int[] arr, int n) {

        int left=0,res=-1,right=n-1,mid=0;
        //将头尾是最小值的情况排除
        while(left<=right){
            if (left == right - 1) {
                break;
            }
            if(arr[left]<arr[right]){
                return left;
            }
            //可能出现在任一边
            mid=(left+right)/2;//找出是降序的那部分
            if (arr[left] > arr[mid]) {//出现在左边
                right = mid;
                continue;
            }
            if(arr[mid]>arr[right]){//出现在右边
                left=mid+1;
                continue;
            }
            while(left<mid){
                if (arr[left] == arr[mid]) {
                    left++;
                } else if (arr[left] < arr[mid]) {
                    return arr[left];
                } else {
                    right = mid;
                    break;
                }
            }
        }
        return res;
    }
}
