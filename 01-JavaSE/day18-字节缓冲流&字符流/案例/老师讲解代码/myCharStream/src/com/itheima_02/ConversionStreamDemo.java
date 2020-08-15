package com.itheima_02;

import java.io.*;

/*
    InputStreamReader：是从字节流到字符流的桥梁
        它读取字节，并使用指定的编码将其解码为字符
        它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集

    OutputStreamWriter：是从字符流到字节流的桥梁
        是从字符流到字节流的桥梁，使用指定的编码将写入的字符编码为字节
        它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集
 */
public class ConversionStreamDemo {
    public static void main(String[] args) throws IOException {
//        OutputStreamWriter​(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter。
//        OutputStreamWriter​(OutputStream out, String charsetName) 创建一个使用命名字符集的OutputStreamWriter。
//        FileOutputStream fos = new FileOutputStream("myCharStream\\osw.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos);
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myCharStream\\osw.txt"));
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myCharStream\\osw.txt"),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myCharStream\\osw.txt"),"GBK");
        osw.write("中国");
        osw.close();

//        InputStreamReader​(InputStream in) 创建一个使用默认字符集的InputStreamReader。
//        InputStreamReader​(InputStream in, String charsetName) 创建一个使用命名字符集的InputStreamReader。
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("myCharStream\\osw.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("myCharStream\\osw.txt"),"GBK");
        //一次读取一个字符数据
        int ch;
        while ((ch=isr.read())!=-1) {
            System.out.print((char)ch);
        }

        isr.close();

    }
}
