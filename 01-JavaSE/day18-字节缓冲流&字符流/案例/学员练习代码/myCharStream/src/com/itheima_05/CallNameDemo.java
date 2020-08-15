package com.itheima_05;

/*
    需求：
        我有一个文件里面存储了班级同学的姓名，每一个姓名占一行，要求通过程序实现随点名器

    思路：
        1:创建字符缓冲输入流对象
        2:创建ArrayList集合对象
        3:调用字符缓冲输入流对象的方法读数据
        4:把读取到的字符串数据存储到集合中
        5:释放资源
        6:使用Random产生一个随机数，随机数的范围在：[0,集合的长度)
        7:把第6步产生的随机数作为索引到ArrayList集合中获取值
        8:把第7步得到的数据输出在控制台
 */
public class CallNameDemo {
    public static void main(String[] args) {
        
    }
}
