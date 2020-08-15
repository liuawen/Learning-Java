package com.itheima_04;

/*
    装箱：把基本数据类型转换为对应的包装类类型
    拆箱：把包装类类型转换为对应的基本数据类型
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //装箱：把基本数据类型转换为对应的包装类类型
        Integer i = Integer.valueOf(100);
        Integer ii = 100; //Integer.valueOf(100);

        //ii += 200;
        // ii = ii + 200;
        // ii = ii.intValue() + 200;
        // ii = 300;
        ii += 200;
        System.out.println(ii);

        Integer iii = null;
//        iii += 100; //NullPointerException
        if(iii != null) {
            iii += 100;
        }

    }
}
