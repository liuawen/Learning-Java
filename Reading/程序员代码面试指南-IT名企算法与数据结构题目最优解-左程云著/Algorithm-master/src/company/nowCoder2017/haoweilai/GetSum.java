package company.nowCoder2017.haoweilai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dell on 2017-09-09.
 */
public class GetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        get(lists,new ArrayList<Integer>(),n,1,m);

        for (List<Integer> list:lists){
            for (int i=0;i<list.size()-1;i++){
                System.out.println(list.get(i)+" ");
            }
            System.out.println(list.get(list.size()-1));
        }
    }
    //用暴力递归去解,dfs
    public static void get(List<List<Integer>> lists, ArrayList<Integer> list,int n, int cur, int target){
        if(target==0){
            lists.add(new ArrayList(list));
        }
        for(int i=cur;i<=n;i++){
            list.add(i);
            get(lists,list,n,i+1,target-i);
            list.remove(list.size()-1);
        }
    }


}
