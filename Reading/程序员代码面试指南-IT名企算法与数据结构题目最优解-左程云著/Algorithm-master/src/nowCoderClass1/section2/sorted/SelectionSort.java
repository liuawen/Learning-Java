package nowCoderClass1.sorted;

/**
 * 选择最小的，交换，放在前面
 * Created by Dell on 2017-04-14.
 */
public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
        int min=0;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[min])
                    min=j;
            }
            int temp=A[min];
            A[min]=A[i];
            A[i]=temp;
        }
        return A;
    }
}
