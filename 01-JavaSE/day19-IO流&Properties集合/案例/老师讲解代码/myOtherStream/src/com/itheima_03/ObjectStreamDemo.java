package com.itheima_03;

import java.io.*;

/*
    用对象序列化流序列化了一个对象后，假如我们修改了对象所属的类文件，读取数据会不会出问题呢？
        java.io.InvalidClassException:
            当序列化运行时检测到类中的以下问题之一时抛出。
                类的串行版本与从流中读取的类描述符的类型不匹配
                该类包含未知的数据类型
                该类没有可访问的无参数构造函数

        com.itheima_03.Student; local class incompatible:
        stream classdesc serialVersionUID = -3743788623620386195,
        local class serialVersionUID = -247282590948908173


    如果出问题了，如何解决呢？
        给对象所属的类加一个值：private static final long serialVersionUID = 42L;

    如果一个对象中的某个成员变量的值不想被序列化，又该如何实现呢？
        private transient int age;
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        write();
        read();
    }

    //反序列化
    private static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myOtherStream\\oos.txt"));
        Object obj = ois.readObject();
        Student s = (Student) obj;
        System.out.println(s.getName() + "," + s.getAge());
        ois.close();
    }

    //序列化
    private static void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myOtherStream\\oos.txt"));
        Student s = new Student("林青霞", 30);
        oos.writeObject(s);
        oos.close();
    }
}
