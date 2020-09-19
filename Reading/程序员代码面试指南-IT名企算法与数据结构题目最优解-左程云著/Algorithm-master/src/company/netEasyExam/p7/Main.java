package company.netEasyExam.p7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dell on 2017-08-13.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();//每天房租
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        if(n<=2){

        }else {
            Arrays.sort(arr);
            int left = 0, right = n - 2;
            int curLeft=arr[n-1], curRight=arr[n-1],sum=0;
            boolean flag=true;//true分配小的，false分配大的
            while(left<right){
                if(flag){
                    sum+=curLeft-arr[left];
                    curLeft=arr[left++];
                    if(left==right){
                        sum+=Math.max(Math.abs(arr[right]-curLeft),Math.abs(arr[right]-curRight));
                        right--;
                    }else {
                        sum += curRight - arr[left];
                        curRight = arr[left++];
                    }
                }else{
                    sum+=arr[right]-curLeft;
                    curLeft=arr[right--];
                    if(left==right){
                        sum+=Math.max(Math.abs(arr[right]-curLeft),Math.abs(arr[right]-curRight));
                        right--;
                    }else{
                        sum+=arr[right]-curRight;
                        curRight=arr[right--];
                    }
                }
                flag=!flag;
            }
            //处理最后一个位置的数
            if(left==right){
                sum+=Math.abs(curLeft-arr[left]);
            }
            System.out.println(sum);
        }
    }
}
