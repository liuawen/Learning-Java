package company.netEasyCollect.p3;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine().trim();
        char[] c=str.toCharArray();
        //将G调整至左端需要交换次数
        int leftG=0,countG=0;//left记录的是下一个G需要放到的位置
        while (leftG<c.length&&c[leftG]=='G'){leftG++;}
        int leftB = 0, countB = 0;//left记录的是下一个G需要放到的位置
        while (leftB<c.length&&c[leftB] == 'B'){leftB++;}
        if(leftG==c.length||leftB==c.length){
            System.out.println(0);
        }else {
            for (int i = leftG; i < c.length; i++) {
                if (c[i] == 'G') {
                    countG += i - leftG;
                    leftG++;
                }
            }
            //将B调整至左端需要交换次数
            for (int i = leftB; i < c.length; i++) {
                if (c[i] == 'B') {
                    countB += i - leftB;
                    leftB++;
                }
            }
            System.out.println(Math.min(countB, countG));
        }
    }

}
