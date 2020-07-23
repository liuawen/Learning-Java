/**
 * @author Liu Awen
 * @create 2018-05-10 15:21
 */

public class a10_8 {
    public static void main(String[] args) {

        String s = "" ;
        s = "abc" ;
        System.out.println( "s : " + s );
        s =  "123" + s ; // 注意 s = "123" + s ; 与 s = s + "123" ; 的区别
        System.out.println( "s : " + s );

        System.out.println( "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~" );

        int x = 25 ;
        String oct = "" ;
        final int p = x ;

        while( x != 0 ){
            int y = x % 8 ;
            oct = y + oct ;
            x /= 8 ;
        }
        oct = "0" + oct;
        System.out.println("0"+oct);

        System.out.println( p + " 的二进制形式是: " + oct );


    }
}
