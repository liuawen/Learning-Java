package company.nowcoder2016;

import java.util.Scanner;

/**
 * 投票出游，有n个地点，从第一个地点开始投票，票数超过一半，就选择该地点
 * 否则不出游，给出每个人的选择顺序，问投票结果
 * Created by Dell on 2017-09-11.
 */
public class SpringOut {
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int num=sc.nextInt();
//        int place=sc.nextInt();
//        int[][] interest=new int[num][num+1];
//        for (int i=0;i<num;i++){
//            for(int j=0;j<num+1;j++){
//                interest[i][j]=sc.nextInt();
//            }
//        }
//
//
//
//    }

    static int[][] p;
    public static boolean judge(int row,int k,int pi,int pj){
        for(int i=0;i<k+1;i++){
            if(p[row][i]==pi)
                return true;
            if(p[row][i]==pj)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n,k;
        while(sc.hasNext()){
            n=sc.nextInt();
            k=sc.nextInt();
            p=new int[n][k+1];
            for(int i=0;i<n;i++)
                for(int j=0;j<k+1;j++)
                    p[i][j]=sc.nextInt();

            int pk=0;
            int vote;
            for(int i=k;i>0;i--){
                vote=0;
                for(int j=0;j<n;j++){
                    if(p[j][0]==i)
                        vote++;
                    else if(judge(j,k,i,0)){
                        if(judge(j,k,i,pk)){
                            vote++;
                        }
                    }
                }
                if(vote>n/2)
                    pk=i;
            }
            if(pk==0)
                System.out.println("otaku");
            else
                System.out.println(pk);
        }

        sc.close();
    }
}
