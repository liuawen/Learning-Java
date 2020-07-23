/**
 * @author Liu Awen
 * @create 2018-05-07 16:32
 */
//字符串拼接
class Test08_Exer6{
    public static void main(String[] args){
        int no = 10;
        String str = "abcdef";
        String str1 = str + "xyz" + no;//abcdefxyz10

        str1 = str1 + "123";//abcdefxyz10123
        char c = '国';

        double pi = 3.1416;
        str1 = str1 + pi;//abcdefxyz101233.1416

        boolean b = false;
        boolean t = true;
        System.out.println("" + b + t);//falsetrue
        System.out.println(b + "" + t);//falsetrue
        /*
         System.out.println(b + t + "");
         Error:(22, 30) java: 二元运算符 '+' 的操作数类型错误
            第一个类型:  boolean
            第二个类型: boolean
        * */
        str1 = str1 + b;//abcdefxyz101233.1416false
        str1 = str1 + c;//abcdefxyz101233.1416false国
        String f = "false";
        System.out.println(b + f);//falsefalse
        System.out.println(f + b);//falsefalse

        System.out.println("str1 = " + str1);
    }
}
