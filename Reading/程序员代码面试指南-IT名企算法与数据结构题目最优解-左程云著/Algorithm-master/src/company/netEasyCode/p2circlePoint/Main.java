package company.netEasyCode.p2circlePoint;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    /**
     * 计算圆上横纵坐标均为整数的点的个数
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(transfer(N));
    }
    public static int transfer(int N){
        int temp1,temp2,count=0;
        for(int i=0;i<Math.ceil(Math.sqrt(N));i++){
            temp1=i*i;
            temp2=(int)Math.ceil(Math.sqrt(N-temp1));
            temp2*=temp2;
            if((temp1+temp2)==N)
                count++;
        }
        return count*4;
    }

}
