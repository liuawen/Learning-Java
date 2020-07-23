/**
 * @author Liu Awen
 * @create 2018-05-07 15:01
 */
/*
运算符：
1、算术运算符
加：+
减：-
乘：*
除：/
	特殊：整数/整数，结果只保留整数部分
取模（取余）：%
	特殊：只看被模数的正负号
	被模数%模数
什么是取模呢  取余呢
2%3=2
正号：+
负号：-
自增 自己加自己不是的  是自己增加1
自增：++
	对于自增变量本身来说，都会+1.
	但是++在前还是在后，对于整个表达式的计算来说是不一样的。
	++在前，先自增，然后取自增后变量的值，
	++在后，先取变量的值，然后变量自增。
	但是不管怎么样，自增变量的取值与自增操作一前一后一定是一起完成的。
自减：--
	类同自增

*/
class Test05_Arithmetic{
    public static void main(String[] args){
        int x = 10;
        int y = 3;

        //System.out.println("x + y = " + x + y);//变为拼接
        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.println("x / y = " + (x / y));
        System.out.println("x % y = " + (x % y));

        System.out.println("----------------------------------");
        //特殊：只看被模数的正负号
        System.out.println("5%2 = " + 5%2);//1
        System.out.println("-5%2 = " + -5%2);//-1
        System.out.println("5%-2 = " + 5%-2);//1
        System.out.println("-5%-2 = " + -5%-2);//-1

        System.out.println("----------------------------------");
        int a = -3;
        System.out.println(-a);//3

        System.out.println("----------------------------------");
        int i = 2;
        i++;
        System.out.println("i = " + i);//3

        int j = 2;
        ++j;
        System.out.println("j = " + j);//3

        System.out.println("----------------------------------");
        int m = 1;
        int n = ++m;//m先自增，然后把m的值取出来赋值给n
        System.out.println("m = " + m);//2
        System.out.println("n = " + n);//2

        System.out.println("----------------------------------");
        int p = 1;
        int q = p++;//（1）先取出p的值"1"，先放到一个“操作数栈”，（2）然后p变量完成自增（3）把刚才放在“操作数栈”中的值赋值给q
        System.out.println("p = " + p);//2
        System.out.println("q = " + q);//1
        System.out.println("q = " + (q = q++));//1
        System.out.println("q = " + q);//1
        System.out.println("----------------------------------");
        int z = 1;
        z = z++;//(1)先取出z的值"1"，先放到一个“操作数栈”，（2）然后z自增，变为2（3）把刚才放在“操作数栈”中的值赋值给z
        System.out.println("z = " + z);//1
        System.out.println("z = " + z++);//1
        System.out.println("z = " + z);//2
        System.out.println("z = " + ++z);//3

        System.out.println("----------------------------------");
        int b = 1;
        int c = 2;
		/*
		第一个：b++
		（1）先取b的值“1”，先放到一个“操作数栈”，
		（2）紧接着b就自增了，b=2
		操作数栈
		第二步：++b
		（1）先b自增，b=3
		（2）紧接着再取b的值“3”，先放到一个“操作数栈”，
		第三步：++b
		（1）先b自增，b=4
		（2）紧接着再取b的值“4”，先放到一个“操作数栈”，
		第四步：c++
		（1）先取c的值“2”，先放到一个“操作数栈”，
		（2）紧接着c自增，c=3
		第五步：算乘 ++b和c++的乘法部分
		4*2 = 8 然后在压回“操作数栈”，
		第六步：再算 b++ + ++b + 乘的结果
			1 + 3 + 8 = 12
		*/
        int d = b++ + ++b + ++b * c++;
        System.out.println("b = " + b);//4
        System.out.println("c = " + c);//3
        System.out.println("d = " + d);//12
    }
}