package com.awen.test08;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 文档注释相关的注解：
 *   文档注释是Java特有的一种注释。
 *   @author：作者
 *   @see：另请参阅
 *   @since：从xx版本引入的
 *
 *   @param：形参
 *   	格式：@param 形参名  形参数据类型  解释
 *   	要求：如果方法有几个形参，就写几个@param
 *   @return：返回值
 *   	格式：@return 返回值类型  解释
 *   	要求：如果方法的返回值类型是void，就不用写了
 *   @throws：抛出的异常  或  @execetion
 *   	格式：@throws 异常类型名  解释
 *   	要求：方法声明可能抛出几种异常，就写几个，没有就不写
 *
 *   建议大家：
 *   	注释与代码要一致，如果不一致，会误导别人或自己
 */

/**
 *
 * @author Irene
 *
 */
public class TestAnnotation2 {

    /**
     * 这是Java的主方法，是Java程序的入口
     * @param args String[] 命令行参数，使用java命令时，在后面传入参数，例如
     * 	java 类名   参数1  参数2 ....
     */
    public static void main(String[] args) {

    }

    /**
     * 这是一个求两个整数中最大值的方法
     * @param a int 其中一个整数
     * @param b int 另一个整数
     * @return int 返回最大值
     */
    public static int getMax(int a, int b){
        return a>b?a:b;
    }

    /**
     * 这是复制一个文件的方法
     * @param src String 源文件
     * @param dest  String 目标文件
     * @throws FileNotFoundException 当源文件找不到时会抛出该异常
     */
    public static void copyFile(String src, String dest) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(src);
        //..
    }

    /**
     *
     */
    public void println(){

    }
}
