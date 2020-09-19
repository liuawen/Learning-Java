package algorithm;

/**
 * 斐波那契数列应用，跳台阶，矩阵覆盖问题
 * Created by Dell on 2017-06-08.
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n<2)
            return n;
        int before=0;
        int now=1;
        int count=n-1;
        int res=0;
        while(count>0){
            res=now+before;
            before=now;
            now=res;
            count--;
        }
        return res;
    }
    public int JumpFloor(int target) {

        if(target<2)
            return target;
        target++;
        int before=0;
        int now=1;
        int count=target-1;
        int res=0;
        while(count>0){
            res=now+before;
            before=now;
            now=res;
            count--;
        }
        return res;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 分析，得出结果为2的n-1次
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        //2的n-1次    计算的方法递归循环，还可以将n根据奇数和偶数判断给出logn的计算方法
        //利用a的n次=a的n/2次*a的n/2次（偶数次），使用位移
        target--;
        return pow(target);
    }
    public int pow(int target){
        if(target==0){
            return 1;
        }
        if(target==1){
            return 2;
        }
        int res=1;
        if((target&1)==0){
            //偶数
            target=target>>1;
            res=pow(target);
            return res*res;
        }else{
            target=target>>1;
            res=pow(target);
            return res*res*2;
        }
    }
}
