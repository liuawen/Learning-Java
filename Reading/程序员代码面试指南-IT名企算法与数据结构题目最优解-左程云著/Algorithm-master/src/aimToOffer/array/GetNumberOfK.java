package array;

/**
 * Created by Dell on 2017-06-12.
 */
public class GetNumberOfK {
    /**
     * 使用二分找到该元素的位置，再继续使用二分，查找第一个K出现的位置，最后一个K出现的位置
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0)
            return 0;
        //使用二分
        int min=0,max=array.length-1,mid=(max+min)/2;
        int first=0,last=0,find=0;
        while(min<=max){
            if(k==array[mid]){
                //找第一个K，最后一个K
                find=1;
                first=findFirstK(array,min,mid-1,k);
                last=findLastK(array,mid+1,max,k);
                break;
            }else{
                if(k<array[mid]){
                    max=mid-1;
                    mid=(max+min)/2;
                }else{
                    min=mid+1;
                    mid=(max+min)/2;
                }
            }
        }
        return last-first+find;
    }

    private int findFirstK(int[] array, int min, int max,int k) {
        if(min<=max){
            if(array[max]!=k)
                return max+1;
            int mid=(min+max)/2;
            if(array[mid]==k){
                return findFirstK(array,min,mid-1,k);
            }else {
                return findFirstK(array,mid+1,max-1,k);
            }
        }
        return min;
    }

    private int findLastK(int[] array, int min, int max,int k) {
        if(min<=max){
            if(array[min]!=k)//min有可能会越界，防止越界
                return min-1;
            int mid=(min+max)/2;
            if(array[mid]==k){
                return findLastK(array,mid+1,max,k);
            }else {
                return findLastK(array,min+1,mid-1,k);
            }
        }
        return max;
    }
}
