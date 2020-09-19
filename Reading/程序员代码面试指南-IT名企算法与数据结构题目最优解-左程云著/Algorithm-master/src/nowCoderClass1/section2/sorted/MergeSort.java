package nowCoderClass1.sorted;

/**
 * Created by Dell on 2017-04-16.
 */
public class MergeSort
{   /**
    *   归并排序，从小到大
    */
    public int[] mergeSort(int[] A, int n) {
        mSort(A,0,n-1);
        return A;
    }

    private void mSort(int[] A, int left, int right) {
        if(left==right)
            return;
        int mid=(left+right)/2;//
        mSort(A,left,mid);
        mSort(A,mid+1,right);
        merge(A,left,mid,right);
    }

    /**
     * 将两部分的数组合并成一部分
     * @param A
     * @param left
     * @param right
     */
    private void merge(int[] A, int left,int mid, int right) {
        //创建一个help数组，将原数组中按有序存放过来
        int[] help=new int[right-left+1];
        //创建几个int，记录当前比较的
        int l=left;
        int r=mid+1;
        int index=0;
        //依次将最小的复制到help数组中,直到某一分区全部复制完成
        while(l<=mid&&r<=right){//判断条件
            if(A[l]<A[r]){
                //复制,并且移动int
                help[index++]=A[l++];
            }else{
                help[index++]=A[r++];
            }
        }
        //如果left区剩余元素,复制
        if(l<=mid){
            while(l<=mid){
                help[index++]=A[l++];
            }
        }
        //如果right区剩余元素,复制
        if(r<=right){
            while(r<=right){
                help[index++]=A[r++];
            }
        }
        //将数组复制到原数组
        for(int i=0; i<help.length; i++){
            A[left+i] =  help[i];
        }
    }
//    /**
//     * 对数组Ad的i,j位置进行排序
//     * @param A
//     * @param i
//     * @param j
//     */
//    private int[] sort(int[] A, int i, int j) {
//        if(A[i]>A[j]){
//            int temp=A[i];
//            A[i]=A[j];
//            A[j]=temp;
//        }
//        return A;
//    }
}
