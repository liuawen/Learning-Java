package company.huawei.p1;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-08.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = 0;
        while((x = in.nextInt())!=0){
            System.out.println(getNum(x));
        }
    }
    public static int getNum(int Num){
        if(Num<2){
            return 0;
        }
        int temp=Num/3;//每次可以直接换到的瓶数
        int empty=temp+Num%3;//直接换掉的加空瓶
        int res=temp;
        while(empty>2){
            temp=empty/3;
            empty=temp+empty%3;
            res+=temp;
        }
        if(empty==2)
            res++;
        return res;
    }
}
