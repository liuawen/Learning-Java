package com.itheima_02;

/*
    使用 == 做比较：
        基本类型：比较的是数据值是否相同
        引用类型：比较的是地址值是否相同

     public boolean equals​(Object anObject)：
        将此字符串与指定对象进行比较。由于我们比较的是字符串对象，所以参数直接传递一个字符串
 */
public class StringDemo02 {
    public static void main(String[] args) {
        //构造方法的方式得到对象
        char[] chs = {'a', 'b', 'c'};
        String s1 = new String(chs);
        String s2 = new String(chs);

        //直接赋值的方式得到对象
        String s3 = "abc";
        String s4 = "abc";

        //比较字符串对象地址是否相同
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("--------");

        //比较字符串内容是否相同
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }
}
