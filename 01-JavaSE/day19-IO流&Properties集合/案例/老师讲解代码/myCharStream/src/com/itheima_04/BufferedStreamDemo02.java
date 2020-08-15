package com.itheima_04;

import java.io.*;

/*
    字符缓冲流的特有功能
        BufferedWriter：
            void newLine()：写一行行分隔符，行分隔符字符串由系统属性定义

        BufferedReader：
            public String readLine()：读一行文字。
                结果包含行的内容的字符串，不包括任何行终止字符，如果流的结尾已经到达，则为null
 */
public class BufferedStreamDemo02 {
    public static void main(String[] args) throws IOException {
        /*
        //创建字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("myCharStream\\bw.txt"));

        //写数据
        for (int i = 0; i < 10; i++) {
            bw.write("hello" + i);
//            bw.write("\r\n");
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
        */

        //创建字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("myCharStream\\bw.txt"));

        //public String readLine()：读一行文字。
        /*
        //第一次读取数据
        String line = br.readLine();
        System.out.println(line);

        //第二次读取数据
        line = br.readLine();
        System.out.println(line);

        //在多读两次
        line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);
        */

        String line;
        while ((line=br.readLine())!=null) {
            System.out.println(line);
        }

        br.close();
    }
}
