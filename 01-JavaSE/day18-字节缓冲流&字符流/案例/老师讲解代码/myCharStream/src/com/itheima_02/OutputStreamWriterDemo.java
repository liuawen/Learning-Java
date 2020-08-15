package com.itheima_02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
    构造方法：
        OutputStreamWriter​(OutputStream out)：创建一个使用默认字符编码的OutputStreamWriter

    写数据的5种方式：
        void write​(int c)：写一个字符
        void write​(char[] cbuf)：写入一个字符数组
        void write​(char[] cbuf, int off, int len)：写入字符数组的一部分
        void write​(String str)：写一个字符串
        void write​(String str, int off, int len)：写一个字符串的一部分
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        //OutputStreamWriter​(OutputStream out)：创建一个使用默认字符编码的OutputStreamWriter
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myCharStream\\osw.txt"));

        //void write​(int c)：写一个字符
//        osw.write(97);
//        //void flush()：刷新流
//        osw.flush();
//        osw.write(98);
//        osw.flush();
//        osw.write(99);

        //void write​(char[] cbuf)：写入一个字符数组
        char[] chs = {'a', 'b', 'c', 'd', 'e'};
//        osw.write(chs);

        //void write​(char[] cbuf, int off, int len)：写入字符数组的一部分
//        osw.write(chs, 0, chs.length);
//        osw.write(chs, 1, 3);

        //void write​(String str)：写一个字符串
//        osw.write("abcde");

        //void write​(String str, int off, int len)：写一个字符串的一部分
//        osw.write("abcde", 0, "abcde".length());
        osw.write("abcde", 1, 3);

        //释放资源
        osw.close();
        //Exception in thread "main" java.io.IOException: Stream closed
//        osw.write(100);
    }
}
