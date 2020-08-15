package com.itheima_01;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    字节流写数据加入异常处理
 */
public class FileOutputStreamDemo04 {
    public static void main(String[] args) {
//        try {
//            FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");
//            fos.write("hello".getBytes());
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //加入finally来实现释放资源
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("myByteStream\\fos.txt");
//            fos = new FileOutputStream("Z:\\myByteStream\\fos.txt");
            fos.write("hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
