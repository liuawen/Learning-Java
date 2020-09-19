package company.didi.p2;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-26.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        Integer k=sc.nextInt();
        String[] strs=line.split(" ");
        if(line==null||line.equals("")||k>strs.length){
            System.out.println(line.equals(""));
            return;
        }
        int[] arr=new int[strs.length];
        int[] A=new int[k];
        for(int i = 0; i < strs.length; i++){
            arr[i]=Integer.valueOf(strs[i]);
            if(i<k){
                A[i]=arr[i];
                if(i==k-1){
                    adjust(A,k-1);
                }
            }else{
                if(arr[i]>A[0]){
                    A[0]=arr[i];
                    adjustHeap(A,0,k-1);
                }
            }
        }
        System.out.println(A[0]);
    }
    public static void adjust(int[] A,int n){
        /**
         * 从最末节点的父节点开始堆化
         */
        for(int i=(n-1)/2;i>=0;i--){
            //将i下沉
            adjustHeap(A,i,n);
        }
    }
    private static void adjustHeap(int[] A,int i,int n){
        int current=i;
        int left=i*2+1;
        int right=i*2+2;
        if(left<=n){
            if(right<=n){
                //左右都有
                int temp=A[left]<A[right]?left:right;
                if(A[temp]<A[current]){
                    swap(A,temp,current);
                    adjustHeap(A,temp,n);
                }
            }else{
                //只有左
                if(A[left]<A[current]){
                    swap(A,current,left);
                }
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp=A[j];
        A[j]=A[i];
        A[i]=temp;
    }
}
