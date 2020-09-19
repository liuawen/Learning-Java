package nowCoderClass1.sorted;

/**
 * 将无序的插入有序序列
 * Created by Dell on 2017-04-14.
 */
public class InsertionSort {
    //默认第一个是有序的
    public int[] insertionSort(int[] A, int n) {
//        int temp=0;//记录要插入的位置
        int i,j,key;
        for(i=1;i<n;i++){//外层控制要排序的总数
            key=A[i];
            for(j=i;j>0&&A[j-1]>key;j--){//内层控制将i元素插入有序序列
               A[j]=A[j-1];
            }
            A[j]=key;
        }
        return A;
    }
}
