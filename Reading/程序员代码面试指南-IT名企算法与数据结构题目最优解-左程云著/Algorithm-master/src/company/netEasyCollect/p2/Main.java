package company.netEasyCollect.p2;

import java.util.Scanner;

/**
* Created by Dell on 2017-08-07.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] tx = new int[n];
            int[] ty = new int[n];
            for (int i = 0; i < n; i ++) {
              tx[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i ++) {
                ty[i] = sc.nextInt();
            }
            int gx=sc.nextInt(),gy=sc.nextInt();
            int walkTime=sc.nextInt(),taxiTime=sc.nextInt();
            System.out.println(quick(tx,ty,gx,gy,walkTime,taxiTime));
        }
    }
    public static int quick(int[] tx,int[] ty,int gx,int gy,int walkTime,int taxiTime){
        int res=(Math.abs(gx)+Math.abs(gy))*walkTime;//走路的时间
        int walk=0,taxi=0;
        for (int i = 0; i < tx.length; i ++) {
            //走到出租点的时间
            walk=walkTime*(Math.abs(tx[i])+Math.abs(ty[i]));
            //从出租点打车过去的时间
            taxi=taxiTime*(Math.abs(gx-tx[i])+Math.abs(gy-ty[i]));
            res=Math.min(res,walk+taxi);
        }
        return res;
    }
}
