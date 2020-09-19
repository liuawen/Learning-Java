package nowCoderClass1.sorted;

/**
 * Created by Dell on 2017-04-14.
 */
public class BubbleSort {
    /**
     * 将最大的数一直冒到队尾
     * @param A 数组
     * @param n 数组的长度
     * @return
     */
    public int[] bubbleSort(int[] A, int n) {
        for(int i=n-1;i>0;i--){//外层控制需要冒几遍才能有序
            for(int j=0;j<i;j++){//内层控制每一次冒泡
               if(A[j]>A[j+1]){
                   int temp=A[j];
                   A[j]=A[j+1];
                   A[j+1]=temp;
               }
            }
        }
        return A;
    }
}
