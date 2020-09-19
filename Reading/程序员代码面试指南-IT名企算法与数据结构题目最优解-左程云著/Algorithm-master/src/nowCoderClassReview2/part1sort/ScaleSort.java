package part1sort;

/**
 * 范围排序，已知一个几乎有序的数组，
 * 几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序
 * Created by Dell on 2017-07-22.
 */
public class ScaleSort{
    public int[] sortElement(int[] A, int n, int k) {
        int[] heap=new int[k];
        for(int i=0;i<k;i++){
            insertHeap(heap,i,A[i]);
        }
        for(int i=k;i<n;i++){
            A[i-k]=heap[0];
            heap[0]=A[i];
            heapify(heap,0,k);
        }
        /**
         * 将剩余元素中依次选出最小的，放入A中
         */
        for(int i=n-k;i<n;i++){
            A[i]=heap[0];
            swap(heap,0,k-1);
            heapify(heap,0,--k);
        }
        return A;
    }

    /**
     * 堆化数组
     * @param heap
     * @param i     i是需要调整的下标
     * @param k
     */
    private void heapify(int[] heap, int i, int k) {
        int left=i*2+1,min;
        int right=i*2+2;
        while(left<k){
            if(right<k){
                min=heap[left]<heap[right]?left:right;
            }else{
                min=left;
            }
            if(heap[min]<heap[i]){
                swap(heap,min,i);
                i=min;
                left=i*2+1;
                right=i*2+2;
            }else{
                break;
            }
        }
    }

    /**
     * 插入元素
     */
    private void insertHeap(int[] heap, int index,int value) {
        heap[index]=value;
        while(index!=0){
            int parent=(index-1)/2;
            if(heap[parent]>heap[index]){
                swap(heap,index,parent);
            }else{
                break;
            }
            index=parent;
        }
    }

    public void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }

}
