package company.lianjia.p3;

import java.util.*;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    private static Map<Integer,Integer> map=new HashMap<>();
    static int cur=2;
    static int count=0;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int res;
            if(n<=count){
                res=map.get(n);
            }else{
                get(n);
                res=map.get(n);
            }
            System.out.println(res);
        }
    }
    public static void get(int n){
        while(count<n) {
            if (judge(cur)) {
                map.put(++count, cur);
            }
            cur++;
        }
    }
    //获取所有的因子
    public static boolean judge(int n){//获得n的所有因子 除1 n外
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
