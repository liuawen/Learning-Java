package com.itheima_01;

import java.io.FileOutputStream;

/*
    字节流写数据加入异常处理
 */
public class FileOutputStreamDemo04 {
    public static void main(String[] args) {
        FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");
        fos.write("hello".getBytes());
        fos.close();
    }
}
