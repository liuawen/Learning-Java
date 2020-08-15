package com.itheima_03;

import java.io.*;

/*
    字节缓冲流：
        BufferOutputStream
        BufferedInputStream

    构造方法：
        字节缓冲输出流：BufferedOutputStream​(OutputStream out)
        字节缓冲输入流：BufferedInputStream​(InputStream in)
 */
public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {
        //字节缓冲输出流：BufferedOutputStream​(OutputStream out)
//        FileOutputStream fos = new FileOutputStream("myByteStream\\bos.txt");
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
        /*
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myByteStream\\bos.txt"));
        //写数据
        bos.write("hello\r\n".getBytes());
        bos.write("world\r\n".getBytes());
        //释放资源
        bos.close();
        */

        //字节缓冲输入流：BufferedInputStream​(InputStream in)
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("myByteStream\\bos.txt"));

        //一次读取一个字节数据
//        int by;
//        while ((by=bis.read())!=-1) {
//            System.out.print((char)by);
//        }

        //一次读取一个字节数组数据
        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1) {
            System.out.print(new String(bys,0,len));
        }

        //释放资源
        bis.close();
    }
}
