package array;

/**
 * Created by Dell on 2017-06-11.
 */
public class OverHalf {
    /**
     * 超过数组长度的一半,利用快排的思路，划分，分成左右两部分，将key相等的放在右边，选择较大的或者有key的一边，继续划分，直到分区小于数组的一半
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length<=1){
            return 0;
        }
        int num=array[0],count=1,maxCount=1,res=array[0];
        for(int index=1;index<array.length;index++){
            if(num==array[index]){
                count++;
                if(count>maxCount){
                    res=array[index];
                }
            }else{
                num=array[index];
                count--;
            }
        }
        return count>=1?res:0;
    }
//    public int MoreThanHalfNum_Solution(int [] array) {
//        return divide(array,0,array.length-1,array.length/2);
//    }
//    public int divide(int[] array,int min,int max,int limit){
//        if(max-min>=limit){//选择第一个元素分区，并统计key出现的次数
//            int left=min+1,right=max,count=1;
//            while(left<=right)
//                if(array[left]<array[min])
//                    left++;
//                else{
//                    if(array[left]==array[min])//相等
//                        count++;
//                    swap(array,left,right);
//                    right--;
//                }
//            if(count>limit){
//                return array[min];
//            }else{//可以不要count，count排除在外，不是要找的
//                swap(array,min,right);//将key交换到中间的位置
//                if(right-1-min<max-right-1)//在两区中选择较大的一个区继续递归
//                    return divide(array,right+1,max,limit);
//                else return divide(array,min,right-1,limit);
//            }
//        }else
//            return 0;
//    }
//    public void swap(int[] array,int i,int j){
//        int temp=array[i];
//        array[i]=array[j];
//        array[j]=temp;
//    }
}
