package company.jingdong.p1.p2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Dell on 2017-09-08.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(count(n));
    }
    public static long count(int n){
        if(n<1){
            return 0;
        }
        HashMap<Long,Long> map=new HashMap<Long,Long>();
        for(int j=1;j<=n;j++) {
            for (int i = 1; i <= n; i++) {
                long muti = (long)Math.pow(j, i);
                map.put(muti, map.get(muti) == null ? 1 : map.get(muti) + 1);
            }
        }
        long res=0;
        //统计
        for(Map.Entry<Long,Long> entry:map.entrySet()){
            res+=entry.getValue()*entry.getValue();
            if(res>1000000007){
                res%=1000000007;
            }
        }
        return res;
    }

}
