package company.nowCoder2017.didi;

import java.util.Scanner;

/**     n的阶层末尾0的个数,5的个数
 * Created by Dell on 2017-09-09.
 */
public class TailZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //统计的方法，n/5值是
        int sum=0;
        while(n>=5){
            n=n/5;
            sum+=n;
        }
        System.out.println(sum);
    }
}
