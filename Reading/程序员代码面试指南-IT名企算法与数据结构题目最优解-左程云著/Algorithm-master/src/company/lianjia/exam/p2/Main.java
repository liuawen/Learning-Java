package company.lianjia.exam.p2;

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
            arr[0]=in.nextInt();
            for(int i=1;i<n;i++) {
                arr[i]=in.nextInt()+arr[i-1];
            }
            int q = in.nextInt();
            int[] query=new int[q];

            for(int i=0;i<q;i++) {
                query[i]=in.nextInt();
            }
            for(int i=1;i<n;i++) {
                System.out.print(arr[i] +"   ");
            }
            System.out.println();
            for(int i=0;i<q;i++){
                int j=0;
                while(j<arr.length&&query[i]>arr[j]){
                    j++;
                }
                System.out.println(j+1);
            }
        }
    }
}
