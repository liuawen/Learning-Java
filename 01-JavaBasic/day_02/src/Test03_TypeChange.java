/**
 * @author Liu Awen
 * @create 2018-05-07 11:43
 */
/*
基本数据类型之间的转换：
（1）自动类型转换
①把存储范围小的类型的值赋值给存储范围大的类型的变量，自动可以完成升级
byte->short->int->long->float->double
		char->
②boolean不参与
③byte,short,char如果进行算术运算都会自动升级为int


（2）强制类型转换
①把存储范围大的类型的值，赋值给存储范围小的类型变量时，需要强制类型转换
double->float->long->int->short->byte
						->char
大的给小的   溢出 sun损失精度
强制类型转换是有风险的：可能会溢出或损失精度
②boolean不参与
③当需要把某个存储范围小的变量强制提升为存储范围大的类型时，也可以使用强制类型转换
*/
class Test03_TypeChange{
    public static void main(String[] args){
		/*
		从左边看d1是double类型
		从右边看10是int类型
		int类型的值，赋值给了double类型的变量，那么它会自动升级为double
		*/
        double d1 = 10;
        System.out.println("d1 = " + d1);//d1 = 10.0


		/*
		从左边看i1是int类型
		从右边看10.0是double类型
		double类型的值，赋值给int类型的变量，如果直接赋值会报错：错误: 不兼容的类型: 从double转换到int可能会有损失
		*/
        //int i1 = 10.3;
        int i1 = (int)10.3;
        System.out.println("i1 = " + i1);//i1 = 10

        byte b1 = 127;
        byte b2 = 2;
        //byte b3 = b1 + b2;//报错：不兼容的类型: 从int转换到byte可能会有损失，因为byte+byte就自动升级为int
        byte b3 = (byte)(b1 + b2);
        // 0111 1111  0000 0010    1
        // 1000 0001
        // 反码 1000 0000  原码 1111 1111  -127
        System.out.println("b3 = " + b3);//b3 = -127

        short s1 = 1;
        short s2 = 2;
        //short s3 = s1 + s2;//short+short会自动升级为int
        short s3 = (short)(s1 + s2);
        System.out.println("s3 = " + s3);//s3 = 3

        char c1 = '0';//'0'的编码值是48
        char c2 = '1';//'1'的编码值是49
        //char c3 = c1 + c2;//char+char会自动升级为int
        char c3 = (char)(c1 + c2);
        System.out.println("c3 = " + c3);//'a' 97
        //c3 = a

        boolean flag = true;
        //int num = (int)flag;//不兼容的类型: boolean无法转换为int

        int x = 1;
        int y = 2;
        System.out.println("x / y = " + x/y);//整数/整数，结果还是整数，只保留整数部分
        System.out.println("x / y = " + (double)x/y);//把x的int类型先强制升级为double类型

    }
}
