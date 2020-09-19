package company.lianjia.exam.p1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            HashSet<Integer> set=new HashSet<>();

            for(int i=0;i<n;i++) {
                set.add(in.nextInt());
            }
            System.out.println(set.size());
            int[] arr=new int[set.size()];
            int i=0;
            for(Integer e:set){
                arr[i++]=e;
            }
            Arrays.sort(arr);
            for(int e=0;e<arr.length-1;e++){
                System.out.print(arr[e]+" ");
            }
            System.out.println(arr[arr.length-1]);
        }
    }
}
