package company.nowcode.spring1;

import java.util.Scanner;

/**
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
 例如 N = 18 L = 2：
 5 + 6 + 7 = 18
 3 + 4 + 5 + 6 = 18
 都是满足要求的，但是我们输出更短的 5 6 7
 * Created by Dell on 2017-09-23.
 */
public class SubArraySum {
    //考虑不到很多细节，最后结果输出时，右移运算的优先级比减号低，使用&| >>注意运算符的优先级
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int sum=sc.nextInt();
        int len=sc.nextInt();
        //判断是否可行，不可行，则len+1继续寻找
        boolean flag=false;
        while(!flag&&len<=Math.min(sum,100)) {
            if ((len & 1) == 0) {//偶数，需要算出中间两个的和,没有考虑是否能除尽
                //和是奇数还是偶数，必须严格区分，偶数是有可能拼出来，奇数是一定拼不出来
                if((sum&1)==0){//和为偶数的情况下
                    if(((len>>1)&1)==0&&(sum%(len>>1))==0&&((sum/(len>>1))&1)==1) {//len的组数必为偶,
                        flag = true;
                    }else{
                        len++;
                    }
                }else{//和为奇数的情况下,len的组数必为奇
                    if(((len>>1)&1)==1&&(sum%(len>>1))==0&&((sum/(len>>1))&1)==1) {//len的组数必为偶
                        flag = true;
                    }else{
                        len++;
                    }
                }
            } else {//长度为奇数，只要算出最中间的那个即可,中间的也有可能是奇数或者偶数
                if (sum % len == 0) {//只要可以除尽，就行
                    flag=true;
                }else{//除不尽，就下一个长度
                    len++;
                }

            }
        }
        if(flag){
            //求出第一个数，然后for循环,len应该分为偶数和奇数
            int first;
//            if((len&1)==0){//偶数
//                first=(sum/len)-(len>>1)+1;
//            }else{//奇数
//                first=(sum/len)-(len>>1);
//            }
                    first=(sum/len)-(((len&1)==0)?((len>>1)-1):(len>>1));
            for(int i=0;i<len-1;i++) {
                System.out.print((first+i)+" ");
            }
            System.out.println((first+len-1));
        }else{
            System.out.println("No");
        }

    }


}
