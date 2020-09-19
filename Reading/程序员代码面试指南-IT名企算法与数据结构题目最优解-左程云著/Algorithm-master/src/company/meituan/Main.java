package company.meituan;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-31.
 */
public class Main {
    //内存超限
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = in.nextInt();
            }
            int K=in.nextInt();
            System.out.println(get(arr,K));
    }
    public static int get(int[] arr,int k){
//        int[][] dp=new int[arr.length][arr.length];
        int res=0;
        for(int i=0;i<arr.length;i++){//控制列数
            for(int j=i;j<arr.length;j++){//控制行
                long sum=0;
                for(int z=j,count=i;count>=0;count--,z--){
                    sum+=arr[z];
                }
                int temp=(int)((sum%k));
                res=temp==0?Math.max(res,i+1):res;
            }
        }
        return res;
    }
}
