/**
 * @author Liu Awen
 * @create 2018-05-09 22:39
 */
/*
原则：先声明后使用

1、声明一个数组？
语法格式;
	元素的数据类型[] 数组名;
	例如：
	存储几个学员的成绩：int[] scores;
	存储几个学员的体重：double[] weights;
	存储几个学员的姓名：String[] names;

2、	数组的初始化？
需要完成两件事：
（1）确定数组的长度
（2）确定数组的元素的值

方式一：静态初始化
	数组名 = new 元素的数据类型[]{元素的值列表};

说明：如果数组的声明与静态初始化合成一句时
	元素的数据类型[] 数组名 = new 元素的数据类型[]{元素的值列表};
	甚至还可以简化：当且仅当，声明与静态初始化在一句时，才能这么简化
	元素的数据类型[] 数组名 = {元素的值列表};
方式二：动态初始化

3、如何表示一个数组的元素
数组名[下标]
下标的范围：[0,长度-1]

4、如何表示数组的长度
数组名.length

5、遍历/访问数组中的元素
for(int i=0; i<数组名.length; i++){
	Ssytem.out.println(数组名[i]);
}

回忆：
变量的声明与使用
（1）变量的声明
数据类型  变量名;
（2）变量的初始化
变量名 = 变量值;

声明和初始化合成一句
数据类型  变量名 = 变量初始值;
*/
class Test02_ArrayDefineAndUse{
    public static void main(String[] args){
        //(1)声明一个数组，用来存储几个学员的成绩
        int[] scores;

        //(2)初始化数组
        //静态初始化
        //数组名 = new 元素的数据类型[]{元素的值列表};
        scores = new int[]{89,45,67,88,90};

        //如果把数组的声明与静态初始化合成一句
        //int[] scores = new int[]{89,45,67,88,90};
        //甚至还可以简化：
        //int[] scores = {89,45,67,88,90};

        System.out.println("数组的长度：" + scores.length);

        //(3)遍历数组
        //下标index的范围:[0,长度-1]
        //下标index的范围:[0,scores.length-1]
        for(int index = 0; index<scores.length; index++){
            //每一个元素，就是数组名[下标]
            System.out.println(scores[index]);
        }
    }
}