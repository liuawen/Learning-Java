/**
 * @author Liu Awen
 * @create 2020-05-06 21:26
 */
/*
Java强类型  非常非常重要
Java中的数据类型：
（1）基本数据类型（8种）
（2）引用数据类型（今天不讲）
String是引用数据类型

一、基本数据类型
1、整型系列
byte: 字节类型 范围：-128~127
	1个字节  8个位
short:短整型
	2个字节  范围：-32768~32767
int:整型
	4个字节  范围：....
long:长整型
	8个字节
	说明：对于long类型的常量，需要加大写L（建议用大写）或小写l

2、小数类型，浮点型系列
float:
	单精度浮点型，4个字节，
	大概的精度范围是，把小数用科学记数法表示后，小数点后6~7位
	说明：float类型的常量，需要在数字后面加F或f
double：双精度浮点型，8个字节
	大概的精度范围是，把小数用科学记数法表示后，小数点后15~16位

L , F ,

3、字符类型
char：单字符类型，2个字节，可以表示汉字
	在Java中是使用Unicode编码表表示。（兼容ASCII码）
	每一个字符都有一个唯一的Unicode编码值。
	例如：
		数字0，Unicode编码值是48
		数字1，Unicode编码值是49
		...
		字母A，Unicode编码值是65
		字母B，Unicode编码值是66
		...
		字母a，Unicode编码值是97
		字母b，Unicode编码值是98
		...
如何表示char类型的字符常量呢？
（1）'一个字符'，例如：'女','A'
（2）'转义字符'，例如：'\n'（换行）,'\t'（制表位Tab键）,
					'\\'（斜杠）,'\"'（双引号）,'\''（单引号）,
					'\b'（删除键Backspace）,'\r'（回车键）
（3）'斜杠u字符的Unicode编码值的十六进制形式'

4、布尔类型
boolean：只能存两个值之一：true,false
一般boolean的值用于条件判断


计算机表示数据用二进制表示，即0和1
那么一位0或1，我们用bit（位），最小单位
计算机中最基本的单位用的byte字节，
1字节 = 8位
1KB = 1024B
1MB = 1024KB
1GB = 1024MB
1TB = 1024GB
...

扩展：
	硬件厂商存储单位用1000进位，不是1024.
	带宽  100Mb,b = bit
    100M  12.5MB/s Mb/s  ？？？
*/
class TestType{
    public static void main(String[] args){
        boolean marry = false;
        if(marry){//marry中的值为true，就表示条件成立
            System.out.println("已婚");
        }else{
            System.out.println("未婚");
        }
        System.out.println("--------------------------");

        byte b = 127;
//        byte b = 129; //不兼容的类型 从int转换到byte可能会有损sun失
        long tel = 18201583096L;

        float f = 1.2F;

        char shuang = '"';//这样可以，表示单个字符
        System.out.println(shuang);
        System.out.println("渐若窥宏大说:\"今天天气真好\"");//这里要输出双引号，需要转义

        char shang = '\u5c1a';
        System.out.println(shang);
    }
}
