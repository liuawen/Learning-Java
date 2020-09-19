package codingInterviewGuide.part4dp;


import java.util.Arrays;

/**
 * 换钱的方法数
 * Created by Dell on 2017-08-10.
 */
public class GetMoneyCount {
    public static int dpNum(int[] arr,int aim){
        //怎么dp
        int[][] dp=new int[arr.length][aim+1];
        for(int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }
        for(int i=arr[0];i<=aim;i+=arr[0]){
            dp[0][i]=1;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=aim;j++){
                dp[i][j]+=dp[i-1][j];
                dp[i][j]+=j-arr[i]>=0?dp[i][j-arr[i]]:0;
            }
        }
        for(int i=0;i<arr.length;i++){
            Arrays.stream(dp[i]).forEach(z->System.out.print("   "+z));
            System.out.println();
        }

        return dp[arr.length-1][aim];

    }
//    public static int getNum(int[] arr,int aim){
//
////        return voilence(arr,0,aim);
//    }
    public static int voilence(int[] arr,int index,int aim){
        if(aim==0){
            return 1;
        }
        if(aim<0||index==arr.length){
            return -1;
        }
        int count=0,temp=0;
        for(int i=0;i<=aim/arr[index];i++){//i表示使用该钱币的张数
            temp=voilence(arr,index+1,aim-i*arr[index]);
            if(temp!=-1){
                count+=temp;
            }
        }
        return count;
    }

}
