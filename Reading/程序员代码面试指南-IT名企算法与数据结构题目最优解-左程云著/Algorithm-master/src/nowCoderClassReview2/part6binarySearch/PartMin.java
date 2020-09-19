package part6binarySearch;

/**
 * 局部最小0<i<N-1，
 * 既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，
 * 那么arr[i]是局部最小。
 * Created by Dell on 2017-07-24.
 */
public class PartMin {
    //使用二分去做
    public int getLessIndex(int[] arr) {
        if(arr.length==0||arr==null)
            return -1;
        if(arr.length==1)
            return 0;
        if(arr[0]<arr[1])
            return 0;
        if(arr[arr.length-1]<arr[arr.length-2])
            return arr.length-1;
        //使用二分搜索
        int left=1,right=arr.length-2,mid;
        while(left<right){
            mid=(left+right)/2;
            if(arr[mid-1]>arr[mid]){
                if(arr[mid+1]>arr[mid])
                    return mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

}
