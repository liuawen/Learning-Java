package nowCoderClass1.section9;

/**
 * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
    给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
 * Created by Dell on 2017-05-25.
 */
public class Distribution {
    public int getWays(int n, int m) {
        if(n==m){
            return 1;
        }
        //n-1个空，m-1个隔板，C kong 隔板
        int count=muti(n-1)/(muti(n-1-(m-1))*muti(m-1));
        return count;
    }
    /**
     * 需要递归求积
     */
    public int muti(int num){
        if(num==1){
            return 1;
        }
        return num*muti(num-1);
    }
}
