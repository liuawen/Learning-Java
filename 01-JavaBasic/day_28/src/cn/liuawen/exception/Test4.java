package cn.liuawen.exception;

import sun.misc.PostVMInitHook;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-29
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("java"));
        //Exception in thread "main" java.lang.NumberFormatException: For input string: "java"
        //	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //	at java.lang.Integer.parseInt(Integer.java:580)
        //	at java.lang.Integer.parseInt(Integer.java:615)
        //	at cn.liuawen.exception.Test4.main(Test4.java:11)
    }
}
