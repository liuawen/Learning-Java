package company.toutiao.p2;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

            int n = in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = in.nextInt() + arr[i - 1];
            }
    }
}
