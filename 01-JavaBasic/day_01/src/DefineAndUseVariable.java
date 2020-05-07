/**
 * @author Liu Awen
 * @create 2020-05-07 0:28
 */
/*
Define：定义，声明
Use：使用
Variable：变量

变量使用的原则：
（1）先声明后使用
包括后面用到的类、方法等，都是遵循先声明后使用
你要声明再使用
声明个女朋友   new一个
光使用不声明？？？。。。
（2）变量必须先初始化（第一次赋值）再访问它的值（打印、计算、比较操作）
必须先初始化
（3）变量的声明，在同一个作用域中，只能声明一次，但是赋值可以很多次
作用域：从变量声明处开始，到它所属的{}结束
我一直给你 一直给你 之前的都没了的
1、如何声明一个变量？
格式：
	数据类型 变量名;

2、如何给变量赋值？
格式：
	变量名 = 变量值;

int double char boolean String
常用的变量的数据类型（刚开始）：
int（整数）
double（小数）
char（单个字符）
String（字符串）
*/
class DefineAndUseVariable{
    public static void main(String[] args){
        //int age;//声明
        //age = 18;//赋值

        //也可以把声明和第一次赋值合并成一句
        int age = 18;
        //	int age = 19;//错误的，第二次赋值不用再加数据类型
        age = 19;//第二次赋值
        System.out.println(age);

        if(true){
            int num = 0;
        }
        //System.out.println(num);//错误的，出了num的作用域

        String name = "菜鸡文";//字符串的常量必须用""（双引号）
        char gender = '女';//单字符的常量，必须用''（单引号）
        double weight = 50.5;//小数类型
        boolean marry = true;//布尔类型    真的，假的，成立，不成立

    }

    public static void test(){
        //System.out.println(age);//错误的，出了age的作用域
    }
}