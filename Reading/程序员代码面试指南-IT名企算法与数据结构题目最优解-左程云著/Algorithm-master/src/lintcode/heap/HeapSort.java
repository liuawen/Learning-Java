package lintcode.heap;

/**
 * 堆排序（大根堆为例）分为两步，第一步堆化数组（从第一个叶子节点开始，大的往上升，小的往下降，也可以从最后一个内部节点开始，依次往下降），
 * 第二步调整数组（insert（插入在堆的末尾，从该末尾大升小降） delete（删除在堆顶，用堆末尾的和堆顶交换，从堆顶开始小降））
 * 下标为i的节点的父节点（i-1）/2，左孩子2*i+1，右孩子2*i+2
 *
 */
public class HeapSort {
    //堆排序时，可以只用down和for循环就够了，因为不用插入
    //如果堆中需要增加一个位置，插入元素，需要增加一个up的函数
    //如果堆的大小不变，删除一个的同时插入一个，也可在堆顶插入，将堆顶的新元素down下去
    public void heapSort(int[] arr){
        //堆化数组,从第一个内部节点开始
        for(int i=(arr.length-1-1)/2;i>=0;i--){
            down(arr,i,arr.length-1);
        }
        //开始
        for(int i=arr.length-1;i>0;i--){
            swap(arr,0,i);
            down(arr,0,i-1);
        }
    }

    //n是下界，i是调整的起点
    public void down(int[] arr,int i,int n){
        if(i<=n){
            if(i*2+1<=n){//有左
                int left=arr[i*2+1];
                if(i*2+2<=n){//有右
                    int right=arr[i*2+2];
                    if(arr[i]>=left&&arr[i]>=right){
                        return;
                    }else{
                        int maxChildIndex=left>right?i*2+1:i*2+2;
                        swap(arr,i,maxChildIndex);
                        down(arr,maxChildIndex,n);
                    }
                }else{//没有右
                    if(arr[i]<left){
                        swap(arr,i,i*2+1);
                    }
                }
            }
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
