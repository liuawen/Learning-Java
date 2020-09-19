package company.lianjia.exam2.p2;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int d = in.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }
            long[][] max = new long[k][n];
            long[][] min = new long[k][n];
            for(int i=0;i<k;i++){
                for(int j=0;j<n;j++){
                    max[i][j] = 1;
                    min[i][j] = 1;
                    if(i==0){
                        min[i][j] = nums[j];
                        max[i][j] = nums[j];
                    }
                }
            }
            for(int i=1;i<k;i++){
                for(int j=0;j<n;j++){
                    for(int m=1;m<=d;m++){
                        if(j-m < 0){
                            if(nums[j] > 0){
                                min[i][j] = Math.min(min[i][j], min[i-1][j-m] + nums[j]);
                                max[i][j] = Math.max(max[i][j], max[i-1][j-m] + nums[j]);
                            }else{
                                min[i][j] = Math.min(min[i][j], max[i-1][j-m] + nums[j]);
                                max[i][j] = Math.max(max[i][j], min[i-1][j-m] + nums[j]);
                            }
                        }
                    }
                }
            }
            long res = 0;
            for(int i=0;i<n;i++){
                if(i>=k-1){
                    res = Math.max(res, max[k-1][i]);
                }
            }
            System.out.println(res);
        }
    }
}
