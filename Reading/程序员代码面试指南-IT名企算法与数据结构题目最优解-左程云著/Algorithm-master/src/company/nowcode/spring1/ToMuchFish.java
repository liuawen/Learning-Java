package company.nowcode.spring1;

import java.util.Scanner;

/**
 * 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证：
 1、放进去的鱼是安全的，不会被其他鱼吃掉
 2、这条鱼放进去也不能吃掉其他鱼
 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
 * Created by Dell on 2017-09-23.
 */
public class ToMuchFish{
    //思路，根据已有的鱼去推测不能放入的鱼，然后从该区间中将不能放入的范围去掉
    //该题不考虑放进去的鱼互相吃的情况
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int minTarget=sc.nextInt();
        int maxTarget=sc.nextInt();
        int num=sc.nextInt();
        int[] fish=new int[num];
        for(int i=0;i<num;i++){
            fish[i]=sc.nextInt();
        }
        System.out.println(get(fish,minTarget,maxTarget));
    }

    private static int get(int[] fish, int minTarget, int maxTarget) {
        //将此范围内的涂黑
        int[] arr=new int[maxTarget-minTarget+1];//初始为0
        for(int i=0;i<fish.length;i++){
            //先计算该鱼会吃掉的范围
            int eatMin=Math.max(1,(int)Math.ceil(fish[i]/10.0))-minTarget;
            int eatMax=Math.max(1,(int)Math.floor(fish[i]/2.0))-minTarget;

            for(int j=Math.max(0,eatMin);j<Math.min(eatMax+1,maxTarget);j++){
                arr[j]=1;
            }
            //再计算该鱼会被吃掉的范围
            int bEatMin=fish[i]*2-minTarget;//也可能超出范围的
            int bEatMax=fish[i]*10-minTarget;
                for (int j = Math.max(bEatMin,0); j < Math.min(maxTarget, bEatMax + 1); j++) {
                    arr[j] = 1;
                }
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                res++;
            }
        }
        return res;
    }

}
