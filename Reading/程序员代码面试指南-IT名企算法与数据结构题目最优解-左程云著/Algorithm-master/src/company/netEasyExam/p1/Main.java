package company.netEasyExam.p1;

/**
 * Created by Dell on 2017-08-12.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        int sum=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        if((max-min)%(n-1)==0){
            int D=(max-min)/(n-1);
            if(D==0){
                int i=1;
                for(i=1;i<n;i++){
                    if(arr[i]!=arr[i-1]){
                        break;
                    }
                }
                if(i==n){
                    System.out.println("Possible");
                }else{
                    System.out.println("Impossible");
                }
            }else {
                int[] temp = new int[n];
                for (int i = 0; i < n; i++) {
                    if ((arr[i] - min) % D == 0) {
                        temp[(arr[i] - min) / D] = 1;
                    }
                }
                int flag = 0;
                for (flag = 0; flag < n; flag++) {
                    if (temp[flag] != 1) {
                        break;
                    }
                }
                if (flag == n) {
                    System.out.println("Possible");
                } else {
                    System.out.println("Impossible");
                }
            }
        }else{
            System.out.println("Impossible");
        }
    }
}