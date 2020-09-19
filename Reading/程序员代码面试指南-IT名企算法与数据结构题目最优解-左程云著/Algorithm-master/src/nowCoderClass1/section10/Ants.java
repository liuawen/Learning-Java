package nowCoderClass1.section10;

/**
 * Created by Dell on 2017-06-02.
 */
public class Ants {
    public int[] collision(int n) {
        //求2的n-1次
        int count=n;
        int res=1;
        while(--count!=0){
            res*=2;
        }
        int[] arr={res-1,res};
        return arr;
    }
}
