package nowCoderClass1.sorted;

/**
 * 在没有空间复杂度的情况下，用哈希表实现
 * 有空间复杂度为O(1)限制的情况下，先排序，再判断
 * Created by Dell on 2017-05-06.
 */
public class Checker {
    /**
     * 选择非递归实现的堆排序，递归实现，调用函数栈，空间复杂度上升
     */
    /**
     * 选择一个O(1)空间复杂度的排序，然后再判断
     * @param a
     * @param n
     * @return
     */
    public boolean checkDuplicate(int[] a, int n) {
        boolean result=false;
        //堆排序
        for(int i=n-1;i>0;i--){
            if(i==n-1){
                heap(a,i);
            }else{
                down(a,0,i);
            }
            swap(a,0,i);
        }
        System.out.print("      1     "+new ShellSort().print(a));
        //判断是否有重复的
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]){
                result=true;
                break;
            }
        }
        return result;
    }
    /**
     * 堆化数组
     */
    public void heap(int[] A,int n){
        for(int i=(n-1)/2;i>=0;i--){
            down(A,i,n);
        }
    }


    /**
     * 调整为大根堆
     */
    public void down(int[] A,int i,int n){
        int left,right,temp;
        left=i*2+1;
        right=i*2+2;
        while(left<=n){
            if(right<=n){//左右均有
                temp=A[left]>A[right]?left:right;//left,right
            }else{
                temp=left;
            }
            if(A[i]<A[temp]){
                swap(A,i,temp);
            }
            i=temp;
            left=i*2+1;
            right=i*2+2;
        }
    }



    private void swap(int[] A, int i, int j) {
        int temp=A[j];
        A[j]=A[i];
        A[i]=temp;
    }


}
