package nowCoderClass1.section12;

/**
 * Created by Dell on 2017-06-04.
 */
public class GoUpstairs {
    public int countWays(int n) {
        if(n==0)
            return 0;
        if(n<=2)
            return n;
        int[] res=new int[n+1];
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=n;i++){
            res[i]=(res[i-1]+res[i-2])%1000000007;
        }
        return res[n];
    }

//    /**
//     * 暴力搜索的方法上台阶
//     * @param n
//     * @return
//     */
//    public int violenceCount(int n){
//        if(n==0)
//            return 0;
//        return violence(n);
//    }
//    public int violence(int n){
//        if(n<=2)
//            return n;
//        return violence(n-1)+violence(n-2);
//    }

}
