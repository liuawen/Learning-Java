package com.itheima;

import java.util.ArrayList;
import java.util.Scanner;

/*
    学生管理系统
 */
public class StudentManager {
    /*
        1:用输出语句完成主界面的编写
        2:用Scanner实现键盘录入数据
        3:用switch语句完成操作的选择
        4:用循环完成再次回到主界面
    */
    public static void main(String[] args) {
		
    }

    //定义一个方法，用于添加学生信息
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象所需要的数据,显示提示信息，提示要输入何种信息
        

        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
       

        //将学生对象添加到集合中
        

        //给出添加成功提示

    }
  

    //定义一个方法，用于查看学生信息
    public static void findAllStudent(ArrayList<Student> array) {
        //判断集合中是否有数据，如果没有显示提示信息
        
        //为了让程序不再往下执行，我们在这里写上return;
        

        //显示表头信息
        //\t其实是一个tab键的位置
        

        //将集合中数据取出按照对应格式显示学生信息，年龄显示补充“岁”
		
	  
    }

    //定义一个方法，用于删除学生信息
    public static void deleteStudent(ArrayList<Student> array) {
        //键盘录入要删除的学生学号,显示提示信息
      

        //遍历集合将对应学生对象从集合中删除
    

        //给出删除成功提示

    }

    //定义一个方法，用于修改学生信息
    public static void updateStudent(ArrayList<Student> array) {
        //键盘录入要修改的学生学号，显示提示信息
        

        //键盘录入要修改的学生信息
       

        //创建学生对象
       

        //遍历集合修改对应的学生信息
       

        //给出修改成功提示

    }
}
