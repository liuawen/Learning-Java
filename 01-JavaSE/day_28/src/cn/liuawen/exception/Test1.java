package cn.liuawen.exception;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-29
 */
public class Test1 {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());//Exception in thread "main" java.lang.NullPointerException
    }
}
