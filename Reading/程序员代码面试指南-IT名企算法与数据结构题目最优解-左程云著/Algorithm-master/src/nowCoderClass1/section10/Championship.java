package nowCoderClass1.section10;

/**
 * 有2k只球队，有k-1个强队，其余都是弱队，
 * 随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？

 给定一个数k，请返回一个数组，其中有两个元素，
 分别为最终结果的分子和分母，请化成最简分数
 * Created by Dell on 2017-05-31.
 */
public class Championship {
    public int[] calc(int k) {
        //先计算能分成多少组
        int groups=1;
        int count=k;
        while(--count!=0){
            groups=groups*(2*count+1);
//            System.out.println(count+"   "+groups);
        }
//        System.out.println("groups  "+groups);
        //计算两强不是一组的,从k+1个中选出k-1个，和强队组合
//        int weap=(k+1)*k/2*muti(k-1,2);
        int weap=1;
        for(int i=3;i<=k+1;i++){
            weap*=i;
        }
//        System.out.println("weap   "+weap);
        int strong=groups-weap;
//        System.out.println("strong    "+strong);
        int maxDivided=gcd(groups,strong);
//        System.out.println("最大公约数   "+maxDivided);
        int[] res=new int[2];
        res[0]=strong/maxDivided;
        res[1]=groups/maxDivided;
        return res;
    }

    /**
     * 辗转相除
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a,int b){
        while(b>0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }

    /**
     * 递归求解num---limit,包含Limit
     */
    public int muti(int num,int limit){
        if(num==limit){
            return limit;
        }
        return num*muti(num-1,limit);
    }
}
