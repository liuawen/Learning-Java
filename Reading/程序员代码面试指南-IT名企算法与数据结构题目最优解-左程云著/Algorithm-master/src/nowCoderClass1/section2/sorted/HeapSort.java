package nowCoderClass1.sorted;

/**
 * 堆排序（完全二叉树）
 * 下标为i的左孩子为2*i+1
 * 下标为i的左孩子为2*i+2
 * 下标为i的父节点为(i – 1) / 2
 *
 * 堆的调整,调整成大根堆，每次将最大的数存在右边，直至有序
 * 堆插入一个数：末尾
 * 堆删除一个数：下标为0处，将末尾的数移至0处，依次下降
 * 数组调整为大根堆的方法，从最末尾的内部节点从后往前开始调整，下沉
 * Created by Dell on 2017-05-04.
 */
public class HeapSort {
    /**
     * 堆排序就是先将整个数组堆化
     * 0和末尾交换，使用down选出最大的，交换，依次进行，直到
     *
     * @param A
     * @param n
     * @return
     */
    public int[] heapSort(int[] A, int n) {
        adjust(A,n-1);
        int tail=n-1;
        do{
            //先将最大的堆顶，索引0交换
            swap(A,0,tail);
            tail--;
            down(A,0,tail);
        }
        while(tail>0);
        return A;
    }

    /**
     * 将数组存储的二叉树调整为大根堆
     * @param A
     * @param n  从0-n要进行调整,n为下界
     */
    public void adjust(int[] A,int n){
        /**
         * 从最末节点的父节点开始堆化
         */
        for(int i=(n-1)/2;i>=0;i--){
            //将i下沉
            down(A,i,n);
        }
    }


    /**
     * 调整为大顶堆
     * 要下沉的节点的下标,有三种情况，有两个孩子，没有孩子，只有左孩子
     * @param A
     * @param n n为下界
     */
    private void down(int[] A,int i,int n){
        int current=i;
        int left=i*2+1;
        int right=i*2+2;
        if(left<=n){
            if(right<=n){
                //左右都有
                int temp=A[left]>A[right]?left:right;
                if(A[temp]>A[current]){
                    swap(A,temp,current);
                    down(A,temp,n);
                }
            }else{
                //只有左
                if(A[left]>A[current]){
                    swap(A,current,left);
                }
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp=A[j];
        A[j]=A[i];
        A[i]=temp;
    }
}
