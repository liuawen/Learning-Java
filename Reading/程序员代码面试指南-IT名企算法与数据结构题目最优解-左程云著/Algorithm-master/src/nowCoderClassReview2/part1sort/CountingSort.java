package part1sort;

/**
 * 计数排序，统计每个元素出现的次数，
 * Created by Dell on 2017-07-22.
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        int min=A[0],max=A[0];
        for(int i=1;i<n;i++){
            if(A[i]>max){
                max=A[i];
            }
            if(A[i]<min){
                min=A[i];
            }
        }
        int[] counts=new int[max-min+1];
        for(int i=0;i<n;i++){
            counts[A[i]-min]+=1;
        }
        //还原到A
        int index=0;
        for(int i=0;i<counts.length;i++){
            while(counts[i]>0){
                counts[i]-=1;
                A[index++]=min+i;
            }
        }
        return A;
    }
}
