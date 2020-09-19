package part1sort;

/**
 * Created by Dell on 2017-07-22.
 */
public class InsertionSort {
    //插入排序，先使前两个有序，将无序的元素插入
    public int[] insertionSort(int[] A, int n) {
        // write code here
        if(n<2){
            return A;
        }
        //将前两个有序
        if(A[0]>A[1]) {
            int temp = A[0];
            A[0] = A[1];
            A[1] = temp;
        }
        int curnum;
        for(int i=2;i<n;i++){//控制插入的数
            curnum=A[i];
            int j=i-1;
            while(j>=0&&A[j]>curnum){
                A[j+1]=A[j];
                j--;
            }
            j=j+1;
            A[j]=curnum;
        }
        return A;
    }
}
