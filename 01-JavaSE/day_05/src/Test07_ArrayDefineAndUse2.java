/**
 * @author Liu Awen
 * @create 2018-05-09 23:03
 */
/*
数组的定义和初始化、使用的方式二：
1、数组的声明？不变
	元素的数据类型[] 数组名;

2、数组的初始化
（1）确定数组的长度
（2）确定数组的元素的值

方式一：静态初始化
	数组名 = new 元素的数据类型[]{元素的值列表};

	说明：（1）数组的长度由{}中的值的个数决定。
		（2）元素的值，在{}中直接指定

方式二：动态初始化
	数组名 = new 元素的数据类型[长度];
	说明：（1）数组的长度在[]指定
		  （2）如果没有手动赋值之前，数组的元素有默认值
		  元素是基本数据类型：
		  byte,short,int,long：0
		  float,double：0.0
		  char：\u0000 字符编码为0的空字符
		  boolean：false
		  元素是引用数据类型：null
		  （3）给元素手动赋值
		  如果没有什么规律，就一个一个赋值；
		  如果有规律，可以使用循环赋值；

3、如何表示数组的长度？
数组名.length

4、如何表示一个数组的元素
数组名[下标]
下标的范围：[0,长度-1]

5、遍历数组
for(int i=0; i<数组的长度; i++){
	System.out.println(数组名[i]);
}
*/
class Test07_ArrayDefineAndUse2{
    public static void main(String[] args){
        //例如：声明一个数组，用来存储26个大写的英文字母
        //(1)声明数组
        //char[] letters;

        //(2)动态初始化
        //数组名 = new 元素的数据类型[长度];
        //①确定数组的长度
        //letters = new char[26];

        //可以把声明与确定数组的长度合成一句
        char[] letters = new char[26];

        //(3)遍历数组的元素
        for(int i=0; i<letters.length; i++){
            System.out.println((int)letters[i]);//发现默认值是\u0000
        }

        //②确定数组的元素的值
        //letters[0] = 'A';
        //letters[1] = 'B';
        //...
        for(int i=0; i<letters.length; i++){
            //数组的元素 = 值;
            letters[i] = (char)('A' + i);
        }

        System.out.println("-------------------------------");
        //(4)遍历数组的元素
        for(int i=0; i<letters.length; i++){
            System.out.println(letters[i]);//发现默认值是\u0000
        }
    }
}





