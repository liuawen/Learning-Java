package part12dp;

public class Main {

    public static void main(String[] args) {
//        int[] p={1,3,6,9};
//        int res=new ExchangeDp().countWays(p,4,19);
//        System.out.println(res);
        int[] p={1,2,3};
        String A="abcdf";
        String B="ab12cd3";

        int res=new MinCost().findMinCost(B,7,A,5,5,3,2);
        System.out.println(res);

    }

}
