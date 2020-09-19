package nowCoderClass1.sorted;

/**已知一个几乎有序的数组，几乎有序是指，
 * 如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 * Created by Dell on 2017-05-04.
 */
public class ScaleSort {
    /**
     *
     * @param A
     * @param n
     * @param k
     * @return
     */
    public int[] sortElement(int[] A, int n, int k) {
        if(A==null||k>n){
            return A;
        }
        /**
         * 创建一个长度为k的数组heap
         * 开始将数组复制进heap，堆化heap（小根堆）
         * 将堆顶置于A[begin]处，将A[begin+k]处的数置于heap[0]处，调整为一个小根堆， begin++，重复
         * 考虑边界情况，如果begin+k>=n-1时，heap[0]处存放的是n和begin的距离
          */
        int[] heap=new int[k];
        for(int i=0;i<k;i++){
            heap[i]=A[i];
        }
        smallHeap(heap,k-1);

        for(int i=0;i<n-1;i++){
            A[i]=heap[0];

            if(i+k>=n){//非正常情况
                heap[0]=heap[n-i-1];
                adjustDown(heap,0,n-2-i);
            }else{//正常情况
                heap[0]=A[i+k];
                adjustDown(heap,0,k-1);
            }
        }
        //最后可能没有将heap中的数组复制到A中，测试最后的边界情况
        A[n-1]=heap[0];
        return A;
    }

    /**
     * 工具方法，调整为小根堆
     */
    private void smallHeap(int[] A,int n){
        for(int i=(n-1)/2;i>=0;i--){
            adjustDown(A,i,n);
        }
    }
    /**
     * 工具方法，将大的数下沉，小的数上升
     * i 要调整数的下标，n 数组的边界
     */
    private void adjustDown(int[] A,int i,int n){
        int left,right,temp;
        left=i*2+1;
        right=i*2+2;
        while(left<=n){
            if(right<=n){//有左右孩子节点
                //从左右孩子中挑选一个最小的
                temp=A[left]<A[right]?left:right;
                if(A[temp]<A[i]){
                    swap(A,temp,i);
                    i=temp;
                    left=i*2+1;
                    right=i*2+2;
                }else
                    break;//不需要继续调整，已经有序
            }else{//只有左孩子节点
                if(A[left]<A[i])
                    swap(A,left,i);
                 break;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp=A[j];
        A[j]=A[i];
        A[i]=temp;
    }

}
