package company.netEasyExam.p5;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-13.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int x=in.nextInt();//每天房租
        int f=in.nextInt();//已有f个水果
        int d=in.nextInt();//钱
        int p=in.nextInt();//水果价格
        int day=f;

        if(x*f<=d){//至少生活f天
            int money=d-x*f;
            day+=money/(p+x);
            System.out.println(day);
        }else{
            day=d/x;
            System.out.println(day);
        }
    }
}
