package company.netEasyCollect.p4;

import java.util.*;

/**
* Created by Dell on 2017-08-07.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> list=get(arr);
            for(int i=list.size()-1;i>0;i--){
                System.out.print(list.get(i)+" ");
            }
            System.out.println(list.get(0));
        }
    }
    public static ArrayList<Integer> get(int[] arr){
        Set<Integer> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            if(!set.contains(arr[i])){
                list.add(arr[i]);
                set.add(arr[i]);
            }
        }
        return list;
    }

}
