package company.netEasyCollect.p5;

import java.util.Scanner;

/**
* Created by Dell on 2017-08-07.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k= sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
              arr[i] = sc.nextInt();
            }
            magic(arr,k);
            for (int i = 0; i < n-1; i ++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println(arr[n-1]);
        }
    }

    private static void magic(int[] arr,int k) {
        int[] res=new int[arr.length];
        //构造矩阵

        int temp=0;
        while(k>0){
            temp=arr[0];
            for(int i=0;i<arr.length-1;i++){
                arr[i]+=arr[i+1];
                if(arr[i]>=100){
                    arr[i]%=100;
                }
            }
            arr[arr.length-1]+=temp;
            if(arr[arr.length-1]>=100){
                arr[arr.length-1]%=100;
            }
            k--;
        }
    }

}
