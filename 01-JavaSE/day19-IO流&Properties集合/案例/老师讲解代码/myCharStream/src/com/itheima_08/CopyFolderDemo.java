package com.itheima_08;

import java.io.*;

/*
    需求：
        把E:\\itcast 这个文件夹复制到模块目录下

    思路：
        1:创建数据源目录File对象，路径是E:\\itcast
        2:获取数据源目录File对象的名称(itcast)
        3:创建目的地目录File对象，路径名是模块名+itcast组成(myCharStream\\itcast)
        4:判断目的地目录对应的File是否存在，如果不存在，就创建
        5:获取数据源目录下所有文件的File数组
        6:遍历File数组，得到每一个File对象，该File对象，其实就是数据源文件
            数据源文件：E:\\itcast\\mn.jpg
        7:获取数据源文件File对象的名称(mn.jpg)
        8:创建目的地文件File对象，路径名是目的地目录+mn.jpg组成(myCharStream\\itcast\\mn.jpg)
        9:复制文件
            由于文件不仅仅是文本文件，还有图片，视频等文件，所以采用字节流复制文件
 */
public class CopyFolderDemo {
    public static void main(String[] args) throws IOException {
        //创建数据源目录File对象，路径是E:\\itcast
        File srcFolder = new File("E:\\itcast");

        //获取数据源目录File对象的名称(itcast)
        String srcFolderName = srcFolder.getName();

        //创建目的地目录File对象，路径名是模块名+itcast组成(myCharStream\\itcast)
        File destFolder = new File("myCharStream",srcFolderName);

        //判断目的地目录对应的File是否存在，如果不存在，就创建
        if(!destFolder.exists()) {
            destFolder.mkdir();
        }

        //获取数据源目录下所有文件的File数组
        File[] listFiles = srcFolder.listFiles();

        //遍历File数组，得到每一个File对象，该File对象，其实就是数据源文件
        for(File srcFile : listFiles) {
            //数据源文件：E:\\itcast\\mn.jpg
            //获取数据源文件File对象的名称(mn.jpg)
            String srcFileName = srcFile.getName();
            //创建目的地文件File对象，路径名是目的地目录+mn.jpg组成(myCharStream\\itcast\\mn.jpg)
            File destFile = new File(destFolder,srcFileName);
            //复制文件
            copyFile(srcFile,destFile);
        }
    }

    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1) {
            bos.write(bys,0,len);
        }

        bos.close();
        bis.close();
    }


}
