package com.itheima_03;


/*
    需求：
        有一个字符串：“91 27 46 38 50”，请写程序实现最终输出结果是：“27 38 46 50 91”

    思路：
        1:定义一个字符串
        2:把字符串中的数字数据存储到一个int类型的数组中
            得到字符串中每一个数字数据？
                public String[] split(String regex)
            定义一个int数组，把 String[] 数组中的每一个元素存储到 int 数组中
                public static int parseInt​(String s)
        3:对 int 数组进行排序
        4:把排序后的int数组中的元素进行拼接得到一个字符串，这里拼接采用StringBuilder来实现
        5:输出结果
 */
public class IntegerTest {
    public static void main(String[] args) {
        //定义一个字符串
        String s = "91 27 46 38 50";

        
    }
}
