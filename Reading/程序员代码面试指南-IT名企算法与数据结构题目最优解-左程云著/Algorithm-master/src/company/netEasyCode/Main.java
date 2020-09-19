package company.netEasyCode;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i = 0; i < n; i++){
            arr[i]= sc.nextInt();
        }
        int k= sc.nextInt();
        int d= sc.nextInt();
//        System.out.println(getMax(arr,k,d));
    }
}
