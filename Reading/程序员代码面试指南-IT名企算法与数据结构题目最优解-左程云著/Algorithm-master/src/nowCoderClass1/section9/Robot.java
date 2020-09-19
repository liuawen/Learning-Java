package nowCoderClass1.section9;

/**
 * 方格移动练习题
 * Created by Dell on 2017-05-25.
 */
public class Robot {
    public int countWays(int x, int y) {
        if(x<2||y<2){
            return 1;
        }
        int sum=muti((x-1)+(y-1))/(muti(x-1)*muti(y-1));
        return sum;
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
