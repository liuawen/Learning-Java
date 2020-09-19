package company.netEasyExam.p4;

/**
 * Created by Dell on 2017-08-12.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int i=0;
        for(i=n-1;i>=0;i-=2){
            System.out.print(arr[i]+" ");
        }
        if(i==-2){
            i=1;
        }else{
            i=0;
        }
        for (;i<n-2;i+=2){
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[i]);

    }
}