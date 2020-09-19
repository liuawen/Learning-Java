package part1sort;

/**
 * Created by Dell on 2017-07-22.
 */
public class MergeSort {
    //归并排序，先递归分组，再两两合并
    public int[] mergeSort(int[] A, int n) {
        divide(A,0,n-1);
        return A;
    }

    private void divide(int[] A, int begin, int end) {
        if(end>begin){
            int mid=(begin+end)/2;
            divide(A,begin,mid);
            divide(A,mid+1,end);
            merge(A,begin,mid,end);
        }
    }

    private void merge(int[] A, int begin, int mid, int end) {
        int a=begin,b=mid+1;
        int[] t=new int[end-begin+1];
        int count=0;
        while(a<=mid&&b<=end){
            if(A[a]<A[b]){
                t[count++]=A[a++];
            }else{
                t[count++]=A[b++];
            }
        }
        //剩余元素拷贝进临时数组
        while(a<=mid){
            t[count++]=A[a++];
        }
        while(b<=end){
            t[count++]=A[b++];
        }
        //再拷贝回去
        count=0;
        for(int i=begin;i<=end;){
            A[i++]=t[count++];
        }
    }
}
