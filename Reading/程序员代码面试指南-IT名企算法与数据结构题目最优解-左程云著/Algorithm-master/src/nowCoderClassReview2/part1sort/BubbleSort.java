package part1sort;

/**
 * Created by Dell on 2017-07-22.
 */
public class BubbleSort {

    //冒泡法,将最大的冒到最后，基于交换的
    public int[] bubbleSort(int[] A, int n) {
        int temp;boolean flag=true;
        for(int i=n-1;i>0;i--){//控制冒泡的次数
            for(int j=0;j<i;j++){//具体的每一次冒泡
                if(A[j]>A[j+1]){
                    flag=false;
                    temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                }
            }
            if(flag)
                break;
        }
        return A;
    }
}
