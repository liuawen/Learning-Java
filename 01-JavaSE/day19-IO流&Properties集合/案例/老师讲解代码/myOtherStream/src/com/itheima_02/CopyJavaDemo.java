package com.itheima_02;

import java.io.*;

/*
    需求：
        把模块目录下的PrintStreamDemo.java 复制到模块目录下的 Copy.java

    思路：
        1:根据数据源创建字符输入流对象
        2:根据目的地创建字符输出流对象
        3:读写数据，复制文件
        4:释放资源
 */
public class CopyJavaDemo {
    public static void main(String[] args) throws IOException {
        /*
        //根据数据源创建字符输入流对象
        BufferedReader br = new BufferedReader(new FileReader("myOtherStream\\PrintStreamDemo.java"));
        //根据目的地创建字符输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("myOtherStream\\Copy.java"));

        //读写数据，复制文件
        String line;
        while ((line=br.readLine())!=null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
        br.close();
        */

        //根据数据源创建字符输入流对象
        BufferedReader br = new BufferedReader(new FileReader("myOtherStream\\PrintStreamDemo.java"));
        //根据目的地创建字符输出流对象
        PrintWriter pw = new PrintWriter(new FileWriter("myOtherStream\\Copy.java"),true);

        //读写数据，复制文件
        String line;
        while ((line=br.readLine())!=null) {
            pw.println(line);
        }

        //释放资源
        pw.close();
        br.close();
    }
}
