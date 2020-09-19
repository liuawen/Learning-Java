package codingInterviewGuide.part4dp;

import java.util.Arrays;

/**
 * Created by Dell on 2017-08-06.
 */
public class LeastNum {
    public static int dpNum(int[] arr,int aim){
        int[] dp=new int[aim+1];
        for(int i=1;i<=aim;i++){//初始化第一种货币
            dp[i]=i%arr[0]==0?i/arr[0]:Integer.MAX_VALUE;
        }
        Arrays.stream(dp).forEach(i->System.out.print("   "+i));
        System.out.println();
        for(int i=1;i<arr.length;i++){//i表示每种货币
            for(int j=1;j<=aim;j++) {
                if(j%arr[i]==0){//能全部用该货币组成，在只用该货币和只用其他货币间权衡,也要在用一张该货币时抉择
                    dp[j]=Math.min(dp[j],j/arr[i]);
                }
                //不能全部用该货币，在该货币用0张，1张，2张之间选择
                    //用一张
                if(j-arr[i]>0){
                        dp[j]=Math.min(dp[j],dp[j-arr[i]]==Integer.MAX_VALUE?Integer.MAX_VALUE:dp[j-arr[i]]+1);
                }//这里可能会下标越界-1，考虑情况

            }
            Arrays.stream(dp).forEach(z->System.out.print("   "+z));
            System.out.println();
        }
//        Arrays.stream(dp).forEach(i->System.out.print("   "+i));
//        System.out.println();
        return dp[aim];
    }
    public static int getNum(int[] arr,int aim){
        int min=0;
        return voilence(arr,0,aim);
    }
    public static int voilence(int[] arr,int index,int aim){
        if(aim==0) return 0;
        if(aim<0||index>=arr.length){
            return -1;
        }
        int count=Integer.MAX_VALUE,temp=0;
        for(int i=0;i<=aim/arr[index];i++){//该种货币从0至最多，每个使用一遍
            temp=voilence(arr,index+1,aim-arr[index]*i);
            if(temp!=-1){
                count=Math.min(count,i+temp);
            }
        }
        return count==Integer.MAX_VALUE?-1:count;
    }
}
