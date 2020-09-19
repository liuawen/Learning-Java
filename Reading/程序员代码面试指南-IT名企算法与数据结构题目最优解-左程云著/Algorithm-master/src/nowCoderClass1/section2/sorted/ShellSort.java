package nowCoderClass1.sorted;

/**
 *希尔排序是特殊的排序，是步长不为1的排序
 * Created by Dell on 2017-05-04.
 */
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        if(A==null || n<2)
            return A;
        int feet=n/2;
        while(feet>0){
            step(A,feet);
            feet=feet/2;
        }
        return A;
    }

    /**
     * 按照指定的步长排序
     * @param A 数组
     * @param i 步长
     */
    private void step(int[] A, int i) {
        int length=A.length;
        int current,front;
        for(int count=i;count<length;count++){
            //进行i位置的数的调整，直至该数字在i步长下有序
            current=count;
            front=count-i;
            for(;front>=0;){
                if(A[current]<A[front]){
                    swap(A,current,front);
                    current=front;
                    front=current-i;
                }else
                    break;
            }
            System.out.println("对"+count+"进行步长为"+i+"的调整-------------"+print(A));
        }
    }
    public String print(int[] A){
        String result="";
        for(int i=0;i<A.length;i++){
            result+="    "+A[i];
        }
        return result;
    }

    private void swap(int[] A, int i, int j) {
        int temp=A[j];
        A[j]=A[i];
        A[i]=temp;
    }

}
