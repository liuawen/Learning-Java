/**
 * @author Liu Awen
 * @create 2018-05-07 16:50
 */
/*
运算符：
2、赋值运算符
（1）基本的赋值运算符：=

赋值操作：永远是把=右边的常量值、变量中值、表达式计算的值赋值给=左边的变量，
即=左边只能是一个变量。

运算的顺序：把右边的整个表达式先算完，才会做最后的赋值操作。

（2）扩展的赋值运算符
例如：
+=
-=
*=
/=
%=
...


*/
class Test09_Assign{
    public static void main(String[] args){
        int x = 1;
        int y = 2 ;
        int z = 3;
//        x + y = z;//=左边只能是一个变量
        //Error:(31, 11) java: 意外的类型
        //  需要: 变量
        //  找到:    值

        byte b1 = 1;
        byte b2 = 2;
        //b2 = b1 + b2;//右边byte + byte结果是int
        b2 += b1;//等价于  b2 = (byte)(b2 + b1);
        System.out.println("b1 = " + b1);//1
        System.out.println("b2 = " + b2);//3

        System.out.println("---------------------------");
        //运算的顺序：把右边的整个表达式先算完，才会做最后的赋值操作。
        int i = 1;
        int j = 5;
        /*
        第一步 i++
        (1)先取i的值 放起来
        (2)i自增，i=2
        第二步 求和
        1 + 5  = 6
        第三步 乘
        j * (和) = 5 * 6 = 30
        第四步 赋值 把乘积赋值给j
         */
        j *= i++ + j;
        System.out.println("i = " +  i);//2
        System.out.println("j = " +  j);//30
    }
}