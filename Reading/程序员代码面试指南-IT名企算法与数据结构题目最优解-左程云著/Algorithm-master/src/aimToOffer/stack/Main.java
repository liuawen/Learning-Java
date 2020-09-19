package stack;

public class Main {

    public static void main(String[] args) {
//        int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[] a={1};int[] b={4};
        boolean res=new PushOrder().IsPopOrder(a,b);
        System.out.println(res);
    }
}
