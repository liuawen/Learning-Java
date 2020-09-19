package company.nowCoder2017.netEasy;

import java.util.Scanner;

/**
 * 网易 合唱团，考察动态规划，子序列乘积，溢出
 * Created by Dell on 2017-09-03.
 */
public class Chorus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i = 0; i < n; i++){
            arr[i]= sc.nextInt();
        }
        int k= sc.nextInt();
        int d= sc.nextInt();
        System.out.println(getMax(arr,k,d));
    }

    private static long getMax(int[] arr, int k, int d) {
//        int[] dp=new int[arr.length];
        long[] max=new long[arr.length];
        long[] min=new long[arr.length];
//        int[] dp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            max[i]=arr[i];
            min[i]=arr[i];
        }
        for(int z=1;z<k;z++) {
            for (int i = arr.length-1; i >=z; i--) {
                long curMax=Math.max(arr[i]*max[i-1],arr[i]*min[i-1]);
                long curMin=Math.min(arr[i]*max[i-1],arr[i]*min[i-1]);
                for (int j = i - 2; j >= Math.max(0, i - d); j--) {
                    curMax=Math.max(curMax,Math.max(arr[i]*max[j],arr[i]*min[j]));
                    curMin=Math.min(curMin,Math.max(arr[i]*max[j],arr[i]*min[j]));
                }
                max[i]=curMax;
                min[i]=curMin;
            }
        }
        //结果应该是遍历最后一行，找出最大的
        long res=max[k-1];
        int count=k;
        while (count<arr.length){
            res=Math.max(res,max[count]);
            count++;
        }
        return res;
    }
}
