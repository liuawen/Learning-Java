package bitOperator;

/**
 * Created by Dell on 2017-06-20.
 */
public class Main {

    public static void main(String[] args){
        int[] a={12,15,24,69,15,69,17,20,17,20};
        int[] b=new int[1];
        int[] c=new int[1];
        new FindTwoLonely().FindNumsAppearOnce(a,b,c);
        System.out.println("     "+b[0]+"    "+c[0]);
    }
}
