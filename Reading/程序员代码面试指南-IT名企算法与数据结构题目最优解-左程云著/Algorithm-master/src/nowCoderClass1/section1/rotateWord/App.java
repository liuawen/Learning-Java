package nowCoderClass1.section1.rotateWord;

/**
 * Created by Dell on 2017-04-14.
 */
public class App {

    public static void main(String[] args){
        KMP kmp=new KMP();
        int[] aa=new int[8];
        kmp.getNext("ABCDABD",aa);
        for(int i=0;i<aa.length;i++){
            System.out.println(i+"               "+aa[i]);
        }
    }


}
