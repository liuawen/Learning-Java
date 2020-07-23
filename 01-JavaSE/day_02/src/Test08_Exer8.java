/**
 * @author Liu Awen
 * @create 2018-05-07 16:41
 */
class Test08_Exer8{
    public static void main(String[] args){
        short s = 5;
//        s = s-2;   //short - int，结果是int
        // int赋值给short Error:(8, 14) java: 不兼容的类型: 从int转换到short可能会有损失

        byte b = 3;
//          b = b + 4;    //byte + int，结果是int
        //Error:(12, 17) java: 不兼容的类型: 从int转换到byte可能会有损失
        b = (byte)(b+4);   //可以
        System.out.println(b);// 3+4 7
        char c = 'a';
        int  i = 5;
        float d = .314F;//非标准写法，如果整数部分是0，可以省略0，但不能省略小数点
        double result = c+i+d;   //char + int + float，结果是float，然后自动升级为double


        byte byte1 = 5;
        short short1 = 3;
//        short t = short1 + byte1;  //short + byte，结果是int
        //Error:(24, 26) java: 不兼容的类型: 从int转换到short可能会有损失
        int t = short1 + byte1;  //short + byte，结果是int
        System.out.println(t);//8
    }
}