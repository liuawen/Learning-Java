/**
 * @author Liu Awen
 * @create 2020-05-16 8:57
 */
/*
1、类的声明的格式：
【修饰符】 class 类名{
}
例如：
class Person{
}

说明：类名，每一个单词的首字母都大写

回忆：如果有一个类是public的，那么源文件名必须与类名相同

2、类的第一类成员：属性
（1）属性的声明
【修饰符】 数据类型 属性名;

3、如何用类来创建对象？
语法格式：
	类名 对象名 = new 类名();
	对象名其实也是变量名/对象的引用

对象名/变量名：从第二个单词开始首字母大写

4、为某个对象的属性赋值
对象名.属性名 = 值;

5、访问某个对象的属性值
例如：打印某个对象的属性值
System.out.println(对象名.属性名);
对象名 属性名
*/
//声明类
class Person{
    //声明属性
    String name;
    int age;
    char gender;
}

//声明类
public class Test01_Class{
    public static void main(String[] args){
        //(1)创建对象
        Person p = new Person();

        //(2)为p对象的name属性赋值
        p.name = "张三";

        //为p对象的age属性赋值
        p.age = 23;

        //为p对象的gender属性赋值
        p.gender = '男';

        //(3)访问/显示对象的属性的值
        System.out.println("姓名：" + p.name);
        System.out.println("年龄：" + p.age);
        System.out.println("性别：" + p.gender);
    }
}
