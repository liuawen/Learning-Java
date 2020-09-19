package company.didi.p1;

/**
 * Created by Dell on 2017-08-26.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        if(line.equals("")){
            return;
        }
        String[] strs=line.split("\\ ");
        int[] arr=new int[strs.length];
            for(int i = 0; i < strs.length; i++){
                arr[i]=Integer.valueOf(strs[i]);
            }
            long max=arr[0];
            long sum=0;
            for(int i = 0; i < arr.length; i++){
                sum+=arr[i];
                if(sum<0){
                    sum=0;
                }
                max=Math.max(max,sum);
            }
            System.out.println(max);
    }
}
