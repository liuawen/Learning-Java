package nowCoderClass1.section9;

/**
 * n个人站队，他们的编号依次从1到n，
 * 要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？
 * 第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？
 * Created by Dell on 2017-05-25.
 */
public class StandInLine {
    public int[] getWays(int n, int a, int b) {
        int[] res=new int[2];
        if(n==2){
            res[0]=1;
            res[1]=1;
            return res;
        }
        //求第一问，a在b的左边的排法，全排列/2
        res[0]=muti(n)/2;
        //求第二问，将两个人看成一个人
        res[1]=muti(n-1);
        return res;
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
