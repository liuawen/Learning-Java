package part6binarySearch;

/**
 * Created by Dell on 2017-07-26.
 */
public class QuickPower {
    //快速n次方，对N除2
    public int getPower(int k, int N) {
        //防止结果越界，必须使用long类型
        long res = 1;
        long temp = k;

        for(; N > 0; N = N>>1){//判断N的末尾
            if((N&1) != 0){//
                res = (res*temp)%1000000007;
            }
            temp = (temp*temp)%1000000007;
        }
        return (int)res;
    }
}
