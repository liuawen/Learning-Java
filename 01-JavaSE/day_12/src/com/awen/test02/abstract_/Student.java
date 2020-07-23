package com.awen.test02.abstract_;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 */
public class Student  extends Person{
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();//Student extends Person

        //编译通过
        System.out.println(person == student);//false
        System.out.println(person.equals(student));//false

        System.out.println("-----------");
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true

        System.out.println("------------");
        String str4 = "java";
        System.out.println(str4 == "java");//true
        System.out.println(str4.equals("java"));//true
        System.out.println("java".equals(str4));//true
        System.out.println(str4.equals(str4));//true
        System.out.println(str4.equals(null));//false
        System.out.println("j".equals('j'));//false


    }
}
