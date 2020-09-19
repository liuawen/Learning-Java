package company.netEasyCollect;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    /**
     * 暗黑字符串
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(transfer(N));
    }
    public static int transfer(int N){
        if(N<3){
            return (int)Math.pow(3,N);
        }
        //统计出全排列的数
        int temp=N-3,res=1;
        for(int i=0;i<N;i++){
            res*=3;
        }
        //统计出纯净的str首次出现在前三位的情况
        int t=1;
        for(int i=0;i<temp;i++){
            t*=3;
        }
        res-=6*t;
        //统计出纯净的str出现在第二位至最后的情况
        t=1;
        for(int i=0;i<temp;i++){
            t*=2;
        }
        if(temp>0)
            res-=6*t;
        return res;
    }

}
