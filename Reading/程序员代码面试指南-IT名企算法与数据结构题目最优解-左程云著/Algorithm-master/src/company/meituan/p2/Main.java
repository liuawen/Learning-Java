package company.meituan.p2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dell on 2017-08-31.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
            int n = in.nextInt();
            int[] arr=new int[n];
            int sum=0;
            for(int i=0;i<n;i++) {
                arr[i] = in.nextInt() + arr[i - 1];
                sum+=arr[i];
            }
        Arrays.sort(arr);
            if(arr[n-1]>=(sum/2)){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }

    }
}
