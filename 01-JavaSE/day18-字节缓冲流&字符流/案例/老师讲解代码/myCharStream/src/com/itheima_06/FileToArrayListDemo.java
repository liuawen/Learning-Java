package com.itheima_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
    需求：把文本文件中的数据读取到集合中，并遍历集合。要求：文件中每一行数据是一个学生对象的成员变量值
          举例：itheima001,林青霞,30,西安

    思路：
        1:定义学生类
        2:创建字符缓冲输入流对象
        3:创建ArrayList集合对象
        4:调用字符缓冲输入流对象的方法读数据
        5:把读取到的字符串数据用split()进行分割，得到一个字符串数组
        6:创建学生对象
        7:把字符串数组中的每一个元素取出来对应的赋值给学生对象的成员变量值
        8:把学生对象添加到集合
        9:释放资源
        10:遍历集合
 */
public class FileToArrayListDemo {
    public static void main(String[] args) throws IOException {
        //创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("myCharStream\\students.txt"));

        //创建ArrayList集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //调用字符缓冲输入流对象的方法读数据
        String line;
        while ((line = br.readLine()) != null) {
            //把读取到的字符串数据用split()进行分割，得到一个字符串数组
            String[] strArray = line.split(",");

            //创建学生对象
            Student s = new Student();
            //把字符串数组中的每一个元素取出来对应的赋值给学生对象的成员变量值
            //itheima001,林青霞,30,西安
            s.setSid(strArray[0]);
            s.setName(strArray[1]);
            s.setAge(Integer.parseInt(strArray[2]));
            s.setAddress(strArray[3]);

            //把学生对象添加到集合
            array.add(s);
        }

        //释放资源
        br.close();

        //遍历集合
        for (Student s : array) {
            System.out.println(s.getSid() + "," + s.getName() + "," + s.getAge() + "," + s.getAddress());
        }
    }
}
