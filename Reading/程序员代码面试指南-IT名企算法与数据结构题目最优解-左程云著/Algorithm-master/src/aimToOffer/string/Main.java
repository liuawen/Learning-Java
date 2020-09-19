package string;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String str="cbfk";
        ArrayList<String> list=new DirectionOrder().Permutation(str);
        for(String s:list){
            System.out.println(s);
        }
//        StringBuffer str=new StringBuffer("ab c hj ds  fd");
//        String res=new Solution().replaceSpace(str);
//        System.out.println(res);
    }
}
