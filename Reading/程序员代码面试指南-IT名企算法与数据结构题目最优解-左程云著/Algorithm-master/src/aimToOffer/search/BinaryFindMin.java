package search;

/**
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * Created by Dell on 2017-06-08.
 */
public class BinaryFindMin {
    /**
     *  有重复元素的递增序列的旋转
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[1];
        }
        //使用二分查找
        return binarySearch(array,0,array.length-1);
    }
    public int binarySearch(int[] array,int min,int max){
        if(max-min>1){
            if(array[min]<array[max]){
                //最小值可能在min处
                return min;
            }else{
                int mid=(min+max)/2;
                //判断升序降序
                    if(array[min]>array[mid]){
                        return binarySearch(array,min,mid);
                    }else{
                        return binarySearch(array,mid,max);//因为min和mid相同，所以范围一直为2
                    }
            }
        }else{
            if(min==max)
                return min;
            else return array[min]<array[max]?min:max;
        }
    }
}
