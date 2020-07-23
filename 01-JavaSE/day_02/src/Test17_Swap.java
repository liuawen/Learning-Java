/**
 * @author Liu Awen
 * @create 2018-05-07 22:23
 */
/*
交换两个变量的值
借助于第三个同样类型的变量
a b c
c = a;
a = b;
b = a;
*/
class Test17_Swap{
    public static void main(String[] args){
        int x = 1;
        int y = 2;

		/*
		通用的方案：适用于任意的数据类型
				借助于第三个通样类型的临时变量
		*/
        int temp = x;//x变量中值就赋值给了temp  temp = 1
        x = y;//再把y中的值放到x中，x = 2
        y = temp;//再把temp中的值赋值给y  y=1
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        temp = x;
        x = y;
        y = temp;
//        x = 1;
//        y = 2;

		/*
		方案二：只适用于int等整数类型  byte short int long
		*/
        x = x ^ y;
        y = x ^ y;//(新的x) ^ 原来的y = (原来的x ^ 原来的y) ^ 原来的y = 原来的x  （求不同）
        x = x ^ y;//(新的x) ^ 新的y = (原来的x ^ 原来的y) ^ 原来的x = 原来的y
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        // y = x ^ y ^ y; y = x; x = x ^ y ^ x;
        x = 1;
        y = 2;
		/*
		方案三：只适用于int等整数类型
			有风险，可能会溢出
		*/
        x = x + y;//有风险，可能会溢出  大了 超了
        y = x - y;//(新的x) - 原来的y = (原来的x + 原来的y)- 原来的y  = 原来的x
        x = x - y;//(新的x) - 新的y = (原来的x + 原来的y) - 原来的x = 原来的y
        System.out.println("x = " + x);
        System.out.println("y = " + y);

		/*
		以下不推荐
		*/
        x = 1;
        y = 2;
        x = x * y;//风险更大
        y = x / y;
        x = x / y;
    }
}