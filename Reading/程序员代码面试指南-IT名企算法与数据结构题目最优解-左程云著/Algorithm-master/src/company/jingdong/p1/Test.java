package company.jingdong.p1;

/**
 * Created by Dell on 2017-09-08.
 */
public class Test {
    public static void main(String[] args) {
        String str="ab";
        char[] c=str.toCharArray();
        c[0]=0;c[1]=0;
        str=String.valueOf(c);

        System.out.println(str.length());
        System.out.println(""==str);
        System.out.println("".equals(str));
    }

}
