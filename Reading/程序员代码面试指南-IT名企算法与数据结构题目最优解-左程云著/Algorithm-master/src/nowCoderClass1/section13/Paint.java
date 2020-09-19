package nowCoderClass1.section13;

/**
 * 涂色练习题，如果有n*m个格子，涂色，不能有公共边
 * Created by Dell on 2017-06-05.
 */
public class Paint {
    public int getMost(int n, int m) {
        int a=n*m%2;
        int b=n*m/2;
        return a==0?b:b+1;
    }
}
