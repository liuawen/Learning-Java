package part1sort;

/**
 * Created by Dell on 2017-07-23.
 */
public class Checker {
    /**
     * 先使用堆排序，大顶堆，每次将堆的最后一个元素和堆顶交换，再堆化
     * @param a
     * @param n
     * @return
     */
//    public boolean checkDuplicate(int[] a, int n) {
//        // write code here
//        //堆化数组，然后取堆顶元素，然后，将数组末尾的元素和堆顶交换，然后，将该元素下沉即可
//        heapSort(a,n);
//    }

    private void heapSort(int[] a, int n) {
        //一路向上调整，遇到下降的要一直下沉到底
        for(int i=n/2;i<n;i++){
            up(a,i);
        }
    }

    private void up(int[] a, int i) {
        int parent=(i-1)/2;
        while(i>0){
            if(a[parent]>a[i]){
                swap(a,parent,i);
                down(a,i);
            }
            i=parent;
            parent=(i-1)/2;
        }
    }
    //遇到一个大的元素，这个大的要沉到最下面
    private void down(int[] a, int i) {

    }
    public void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
