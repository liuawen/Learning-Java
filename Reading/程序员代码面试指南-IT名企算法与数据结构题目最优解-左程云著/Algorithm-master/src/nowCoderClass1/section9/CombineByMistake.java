package nowCoderClass1.section9;

/**
 * Created by Dell on 2017-05-27.
 */
public class CombineByMistake {
    /**
     * 递归，
     * 假设第n封信放入第i个信封
     * 情况1，第i封信也放入第n个信封，后续为F(n-2)   除去n，i
     * 情况2，第i封信没有放入第n个信封，后续F(n-1)
     *          每封信都有n-1-1种方法，好比n封信，除了自己不能放，其余的都可以放
     * 递归解决     i的选择有n-1种   f(n)=(n-1)*(F(n-1)+F(n-2))
     * @param n
     * @return
     */
    public int countWays(int n) {
        if(n == 1){
            return 0;
        }
        long[] res = new long[n+1];
        res[2] = 1;
        for(int i=3;i<=n;i++){
            res[i] = (i-1)*(res[i-1] + res[i-2])%1000000007;
        }
        return (int)res[n];
    }
}
