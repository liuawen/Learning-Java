package company.netEasyCollect.p6;

import java.util.HashSet;
import java.util.Scanner;

/**
* Created by Dell on 2017-08-07.
*/
public class Main {
    public static int cases=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            cases=0;
            int n = sc.nextInt();sc.nextLine();
            String[] arr = new String[n];
            for (int i = 0; i < n; i ++) {
              arr[i] = sc.nextLine();
            }
            plan(arr,0, new HashSet<Integer>());
            System.out.println(cases);

        }
    }
    //安排工作,用递归做
    public static void plan(String[] arr, int index, HashSet<Integer> s){
        if(index>=arr.length){
            cases++;
            return;
        }
        String able=arr[index];
        for(int i=0;i<able.length();i++){
            int work=able.charAt(i);
//            System.out.println(able.charAt(i)+"    "+(able.charAt(i)-'0')+"    "+work);
            if(!s.contains(work)){
                s.add(work);
                plan(arr,index+1,s);
                s.remove(work);
            }
        }
    }


}
