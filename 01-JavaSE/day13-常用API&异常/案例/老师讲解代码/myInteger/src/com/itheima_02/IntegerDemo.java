package com.itheima_02;

/*
    构造方法：
        public Integer(int value)：根据 int 值创建 Integer 对象(过时)
        public Integer(String s)：根据 String 值创建 Integer 对象(过时)

    静态方法获取对象：
        public static Integer valueOf​(int i)：返回表示指定的 int 值的 Integer 实例
        public static Integer valueOf​(String s)：返回一个保存指定值的 Integer 对象 String
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //public Integer(int value)：根据 int 值创建 Integer 对象(过时)
        Integer i1 = new Integer(100);
        System.out.println(i1);

        //public Integer(String s)：根据 String 值创建 Integer 对象(过时)
        Integer i2 = new Integer("100");
//        Integer i2 = new Integer("abc"); //NumberFormatException
        System.out.println(i2);
        System.out.println("--------");

        //public static Integer valueOf​(int i)：返回表示指定的 int 值的 Integer 实例
        Integer i3 = Integer.valueOf(100);
        System.out.println(i3);

        //public static Integer valueOf​(String s)：返回一个保存指定值的 Integer 对象 String
        Integer i4 = Integer.valueOf("100");
        System.out.println(i4);
    }
}
