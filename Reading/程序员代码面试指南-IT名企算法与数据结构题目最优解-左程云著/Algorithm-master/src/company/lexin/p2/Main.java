package company.lexin.p2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dell on 2017-09-23.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] strs=sc.nextLine().split(" ");
        double[] nums=new double[strs.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Double.valueOf(strs[i]);
        }
        Arrays.sort(nums);
        double res=0;
        for(int i=nums.length-1;i>=0;i-=2){
            res+=nums[i];
        }
        System.out.println(String.format("%1$.2f", res));
    }
}
