package company.nowcode.spring1;

import java.util.Scanner;

/**
 * 牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：在这本算法书页码中0~9每个数字分别出现了多少次？
 * Created by Dell on 2017-09-24.
 */
public class CountPage {
    //还未正确解答
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int page=sc.nextInt();
        char[] chars=String.valueOf(page).toCharArray();
        int[] res=new int[10];
        //统计0,0依次放在第二个位置，第三个位置，直至最后
        //0还需要位数为2，位数为3的情况，加起来才行
        int allKind=0;
        for(int i=1;i<chars.length;i++){//0放置在第二个位置上，一直往后放
            for(int z=0;z<i;z++) {//z控制放在i位置上，当前总的
                int kind = 1;
                for (int j = z; j < chars.length; j++) {//总位数从j至
                    if (j != i) {
                        if (j == z) {//第一个位置不能放0
                            kind *= (chars[j] - '0');
                        } else {
                            kind *= (chars[j] - '0' + 1);
                        }
                    }
                }
                allKind+=kind;
            }
        }
        res[0]=allKind;

        for(int digit=1;digit<=9;digit++){//从1-9统计每个数出现的次数
            allKind=0;
            for(int i=0;i<chars.length;i++){//依次尝试放在第一位，第二位，第三位
                int kind = 1;
                    for (int j = 0; j < chars.length; j++) {//总位数从j至
                        if (j != i) {
                            if((j==i-1)&&(chars[i]-'0')<digit){//次高位少计算一个
                                kind *= Math.max((chars[j] - '0'),1);
                            }else{
                                kind *= (chars[j] - '0' + 1);
                            }
                        }
                    }
                if(!(kind==1&&digit>(chars[i]-'0'))){
                    allKind+=kind;
                }
            }
            res[digit]=allKind;
        }
        //输出
        for(int i=0;i<res.length-1;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println(res[9]);
    }
    public static long getFactorCount(long num,byte factor){
        long count=0;
        long current=0,next=0,before=0;
        long i=1;

        while((num/i)!=0){
            current=(num/i)%10;
            next=num/(i*10);
            before=num-(num/i)*i;

            if(current<factor){
                count+=next*i;
            }
            else if(current==factor){
                count+=next*i+before+1;
            }
            else if(current>factor)
                count+=(next+1)*i;

            i*=10;
        }
        return count;
    }

}
