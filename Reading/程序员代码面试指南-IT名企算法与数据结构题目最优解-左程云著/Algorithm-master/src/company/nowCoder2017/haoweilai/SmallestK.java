package company.nowCoder2017.haoweilai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 使用堆排序
 * Created by Dell on 2017-09-09.
 */
public class SmallestK {
    //建堆的过程，每次末尾插入，将该元素一直上升，直至有序即可
    //调整的过程，0位置为无序的，将0位置的元素一直下沉，并选择合适的上升
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] strs=str.split(" ");
        int k=Integer.valueOf(strs[strs.length-1]);
        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=Integer.valueOf(strs[i]);
            insertHeap(arr,i);
        }
        int cur=0;
        for(int i=k;i<strs.length-1;i++){
            cur=Integer.valueOf(strs[i]);
            if(cur<arr[0]){
                arr[0]=cur;
                heapfiy(arr,0);
            }
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[arr.length-1]);
    }
    //大根堆
    public static void insertHeap(int[] arr,int i){
        int parent=(i-1)/2;
        if(parent>=0){
            if(arr[i]>parent){
                swap(arr,i,parent);
                if(parent!=0) {
                    insertHeap(arr,parent);
                }
            }
        }
    }
    //调整数组，i从0开始将小的下沉，n为截止点
    public static void heapfiy(int[] arr,int i){
        int left=i*2+1;
        int right=i*2+2;
        if(right<arr.length){
            int index=arr[left]>arr[right]?left:right;
            if(arr[i]<arr[index]){
                swap(arr,i,index);
                heapfiy(arr,index);
            }
        }else{
            if(left<arr.length){
                if(arr[i]<arr[left]){
                    swap(arr,i,left);
                    heapfiy(arr,left);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }





}


