package nowCoderClass1.section9;

/**
 * 假设有n对左右括号，请求出合法的排列有多少个？
 * 合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。
 给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
 * 卡特兰数     公式1：h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
 * Created by Dell on 2017-05-27.
 */
public class Parenthesis {
    //


    public int countLegalWays(int n) {
        //卡特兰数的解为H(n)=C(2n,n)/(n+1)
        if(n<=2){
            return n;
        }
        return muti(2*n,n+2)/muti(n);
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
