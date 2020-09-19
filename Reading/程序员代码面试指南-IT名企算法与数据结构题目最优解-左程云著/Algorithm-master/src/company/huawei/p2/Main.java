package company.huawei.p2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dell on 2017-08-08.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        Arrays.sort(arr);
        int pre=arr[0];
        System.out.println(pre);
        for(int i=1;i<n;i++){
            if(arr[i]!=pre){
                pre=arr[i];
                System.out.println(arr[i]);
            }
        }
    }

//    private static int[] get(int[] arr) {
//
//    }

}
