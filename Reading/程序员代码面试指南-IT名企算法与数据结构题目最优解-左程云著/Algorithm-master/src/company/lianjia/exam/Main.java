package company.lianjia.exam;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = in.nextInt() + arr[i - 1];
            }
        }
    }
}
