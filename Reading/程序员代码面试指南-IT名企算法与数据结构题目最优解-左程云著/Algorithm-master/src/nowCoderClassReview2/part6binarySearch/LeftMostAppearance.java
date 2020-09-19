package part6binarySearch;

/**
 * Created by Dell on 2017-07-24.
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        int res=-1,left=0,right=n-1,mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]>num){
                right=mid-1;
            }else if(arr[mid]<num){
                left=mid+1;
            }else{
                res=mid;
                right=mid-1;
            }
        }
        return res;
    }
}
