package part8bit;

/**
 * Created by Dell on 2017-07-28.
 */
public class Compare
{
    /*  此方法可能溢出 ，
     int c=a-b;//假设a大,c正    0
     int scA=sign(c);   1
     int scB=flip(scA); 0
     return a*scA+b*scB;    第二项为0
     */
    public int getMax(int a, int b) {
        //此方法可防止溢出带来的错误
        int c=a-b;
        int sa=sign(a);//a正得1   a负得0
        int sb=sign(b);
        int sc=sign(c);
        int difSab=sa^sb;
        int sameSab=flip(difSab);
        int returnA=difSab*sa+sameSab*sc;
        int returnB=flip(returnA);
        return a*returnA+b*returnB;
    }
    //正 得1  负   得0
    public int sign(int n) {
        return flip((n>>31)&1);//带符号右移31位，只剩符号位，0正，得0   1负，得1
    }

    private int flip(int n) {
        return n^1;//如果是1，返回0，如果是0，返回1
    }

}
