package lintcode.dp;

/**
 * Created by Dell on 2017-08-29.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        // write your code here
        if(n<=2){
            return n;
        }
        int one=1;
        int two=2;
        int count=3;
        while(count<=n){
            if((count&1)==1){
                one=one+two;
            }else{
                two=one+two;
            }
            count++;
        }
        return (count&1)==1?two:one;
    }
}
