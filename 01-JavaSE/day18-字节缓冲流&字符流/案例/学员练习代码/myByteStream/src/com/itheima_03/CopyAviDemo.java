package com.itheima_03;

/*
    需求：
        把E:\\itcast\\字节流复制图片.avi 复制到模块目录下的 字节流复制图片.avi

    思路：
        1:根据数据源创建字节输入流对象
        2:根据目的地创建字节输出流对象
        3:读写数据，复制图片(一次读取一个字节数组，一次写入一个字节数组)
        4:释放资源

    四种方式实现复制视频，并记录每种方式复制视频的时间
        1:基本字节流一次读写一个字节             
        2:基本字节流一次读写一个字节数组          
        3:字节缓冲流一次读写一个字节             
        4:字节缓冲流一次读写一个字节数组         
 */
public class CopyAviDemo {
    public static void main(String[] args) {
        //记录开始时间
        long startTime = System.currentTimeMillis();

        //复制视频

        //记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时：" + (endTime - startTime) + "毫秒");
    }
}
