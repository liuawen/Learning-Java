package nowCoderClass1.section10;

/**
 * Created by Dell on 2017-06-02.
 */
public class MaxCommonDivisor {
    /**
     * 辗转相除法,用较大的数除较小的数，取余，再用小的数一直取余，知道余数为0，就找到最大公约数了
     */
    public int divisionAlgorithm(int a,int b){
        //一直相除，直到两者相等或两者中一个等于1
        int min=a>b?a:b;
        int max=a>b?b:a;
        int res=max;
        do{
            max=res>min?res:min;
            min=res>min?min:res;
            res=max%min;
        }while(res==0);
        return min;
    }

    /**
     * 辗转相除法，递归
     * @param a
     * @param b
     * @return
     */
    public int division(int a,int b){
        if(a>b){
            return gcd(a,b);
        }else{
            return gcd(b,a);
        }
    }


    /**
     * 更相减损法
     */
    public int reduce(int a,int b){
        if(a>b){
            return gcr(a,b);
        }else {
            return gcr(b,a);
        }
    }

    /**
     * 相减
     * @param a 较大
     * @param b 小
     * @return
     */
    private int gcr(int a, int b) {
        int res=a-b;
        if(res==0){
            return b;
        }
        if(res>b){
            return gcr(res,b);
        }else{
            return gcr(b,res);
        }
    }

    /**
     * 递归，取余
     * @param b
     * @param a
     */
    private int gcd(int a, int b) {
        int res=a%b;
        if(a%b==0)
            return b;
        else{
            return gcd(b,res);
        }
    }

    /**
     * 利用位移,更相减损，得到两数的最大公约数
     * a,b均为偶数，gcb(a,b)=2*gcb(a/2,b/2)=2*gcb(a>>1,b>>1)
     * a偶b奇，gcb(a,b)=gcb(a/2,b)=gcb(a>>1,b)
     * a,b均为奇数，gcb(a,b)=gcb(b,a-b),两数必为偶数，又可继续计算
     *
     */
    public int gce(int a,int b){//保证a大，b小
        if(a==b)
            return a;
        //和1做按位与，判断奇偶
        if(a<b){
            return gce(b,a);
        }else{
            if((a&1)==1)//1的二进制是001，&的结果只有两种，0和1
                if((b&1)==1)//a为奇数//ab均为奇数
                    return gce(a-b,b);
                else//a奇b偶
                    return gce(a,b>>1);
             else //a为偶数
                if((b&1)==1)//b为奇数
                    return gce(a>>1,b);
                else//b为偶数
                    return 2*gce(a>>1,b>>1);
        }
    }
}
