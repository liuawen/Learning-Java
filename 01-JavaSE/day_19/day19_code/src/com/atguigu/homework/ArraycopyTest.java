package com.atguigu.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-25
 */
public class ArraycopyTest {
    public static void main(String[] args) {
        char[] cha = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'a', 'd'};
        //将cha数组中第3个元素，复制到目标数组最后的第二位数组上
        System.arraycopy(cha, 2, cha, 8, 1);
        //遍历目标数组，在控制台输出字符串
        for (int i = 0; i < cha.length; i++) {
            System.out.print(cha[i]);
        }
        //helloworld
    }
}
