package part1sort;

/**
 * i的父(i-1)/2   i的左右是i*2+1  i*2+2
 * n个元素的最早的叶节点是n/2
 * Created by Dell on 2017-07-22.
 */
public class HeapSort {
    //堆排序，直接调整即可，
    public int[] heapSort(int[] A, int n) {
        // write code here
        for(int i=n-1;i>0;i--){
            for(int j=(i+1)/2;j<=i;j++){//找到最大的
                adjustHeap(A,j);
            }
            swap(A,0,i);
        }
        return A;
    }
    //调整堆，根据index，找到其父，一直将小的调整到上面即可
    public void adjustHeap(int[] A,int index){
        int parent=(index-1)/2;
        while(parent>0){
            if(A[parent]<A[index]){
                swap(A,parent,index);
                //注意将大的交换上去之后，小的要下沉，否则会出现错误
            }
            index=parent;
            parent=(index-1)/2;
        }
        if(parent==0){
            if(A[parent]<A[index]){
                swap(A,parent,index);
            }
        }
    }
    public void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
