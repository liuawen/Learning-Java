package nowCoderClass1.section6;

/**
 * Created by Dell on 2017-05-11.
 */
public class BinarySearch {
    /**
     * 二分查找，注意临界的判断
     * @param A
     * @param n
     * @return
     */
    public int binarySearch(int[] A,int n,int val){
        int low,max;
        low=0;max=n-1;
        return binarySearch(A,low,max,val);
    }

    private int binarySearch(int[] a, int low, int max,int val) {
        if(low<=max){
            int mid=(low+max)/2;
            if(a[mid]==val){
                return mid;
            }else{
                if(a[mid]<val){//右边
                    low=mid+1;
                    return binarySearch(a,low,max,val);
                }else{
                    //左边
                        max=mid-1;
                        return binarySearch(a,low,max,val);
                }
            }
        }
        return -1;
    }
}
