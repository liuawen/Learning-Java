package part1sort;

/**
 * Created by Dell on 2017-07-22.
 */
public class QuickSort {
    //选择一个分区元素，将比他小的放左边，比他大的放右边,
    //回顾快排的优化
    public int[] quickSort(int[] A, int n) {
        //选择第一个元素
        quickSort(A,0,n-1);
        return A;
    }

    public void quickSort(int[] A,int begin,int end){
        if(begin<end){//至少有两个元素
            int b=begin+1;
            int e=end;
            while(b<=e){
                if(A[b]<A[begin]){
                    b++;
                }else{
                    swap(A,b,e);
                    e--;
                }
            }
            //将分区元素交换至中间，e,e后面的是比e大的
            swap(A,begin,e);
            quickSort(A,begin,e-1);
            quickSort(A,e+1,end);
        }
    }
    public void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }


}
