package part1sort;

/**
 * Created by Dell on 2017-07-22.
 */
public class SelectionSort {
    //选择排序，选择最小的放在前面
    public int[] selectionSort(int[] A, int n) {
        int min,temp;
        for(int i=0;i<n-1;i++){//每次选出最小的下标，放在i位置
            min=i;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[min]){
                    min=j;
                }
            }
            if(min!=i){
                temp=A[i];
                A[i]=A[min];
                A[min]=temp;
            }
        }
        return A;
    }
}
