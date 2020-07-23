package cn.liuawen.exception;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-29
 */
/*
3.定义测试类Test9
 a)提供main方法,在main方法中
  i.使用满参构造方法创建Student对象,分数传入一个负数,运行程序
  ii.由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码
  iii.使用空参构造创建Student对象
  iv.调用setScore(int score)方法,传入一个正数,运行程序
  v.调用setScore(int score)方法,传入一个负数,运行程序
 */

public class TestStudent {
    public static void main(String[] args) {
//  i.使用满参构造方法创建Student对象,分数传入一个负数,运行程序
//  Student s = new Student("景甜", -10);
//  ii.由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码

//  iii.使用空参构造创建Student对象
        Student s = new Student();
//  iv.调用setScore(int score)方法,传入一个正数,运行程序
        s.setScore(100);
//  v.调用setScore(int score)方法,传入一个负数,运行程序
        s.setScore(-5);//Exception in thread "main" cn.liuawen.exception.NoScoreException: :分数不能为负数:-5
    }
}
