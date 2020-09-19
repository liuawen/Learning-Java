package company.briup;

/**
 * Created by Dell on 2017-07-21.
 */
public class BagTest {
    private int[] gw;

    public BagTest(int[] gw) {
        this.gw = gw;
    }
    public boolean knap(int weight){
        return knap(weight,gw.length-1);
    }

    /**
     *
     * @param s     重量
     * @param n     物品的数量
     * @return      是否能找到一种方案
     */
    private boolean knap(int s, int n) {
        if(s==0)
            return true;
        if(s<0||(s>0&&n<1))
            return false;
        //第一个是选择该物品，第二个是不选该物品
        if(knap(s-gw[n],n-1)||knap(s,n-1)){
            System.out.printf("%4d\n",gw[n]);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int totalWeight=15;
        //装包的总重量
        int[] w=new int[]{0,1,4,3,4,5,2,7};
        //若干个物品的重量值
        BagTest bt=new BagTest(w);
        if(bt.knap(totalWeight))
            System.out.println("OK!");
        else
            System.out.println("NO!");
    }
}
