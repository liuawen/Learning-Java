package homework;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
声明公民类Citizen，包含属性：姓名，生日，身份证号，
其中姓名是String类型，生日是MyDate类型，身份证号也是String类型。
创建你们家庭成员的几个对象，并打印信息。
*/
class Day07_Test03{
    public static void main(String[] args){
        //1、创建爸爸的对象
        Citizen baba = new Citizen();
        baba.name = "小头爸爸";
        baba.cardId = "1111111";
        //左边的birthday是一个引用数据类型的变量，右边就需要赋值一个对象
        baba.birthday = new MyDate();
        //baba.birthday是对象名   对象名.属性值
        baba.birthday.year = 1967;
        baba.birthday.month = 5;
        baba.birthday.day = 2;
        //感觉有点奇怪呢

        //2、创建妈妈的对象
        Citizen mama = new Citizen();
        mama.name = "围裙妈妈";
        mama.cardId = "222222";

        MyDate bir = new MyDate();
        bir.year = 1970;
        bir.month = 6;
        bir.day = 1;
        //直接给  整个对象弄好了  然后复制过去
        mama.birthday = bir;

        System.out.println("爸爸的姓名：" + baba.name + "，身份证号：" + baba.cardId + "，生日：" + baba.birthday.year+"年" + baba.birthday.month + "月" + baba.birthday.day+"日");
        System.out.println("妈妈的姓名：" + mama.name + "，身份证号：" + mama.cardId + "，生日：" + mama.birthday.year+"年" + mama.birthday.month + "月" + mama.birthday.day+"日");
    }
}
//用Test04的对象
/*class MyDate{
    int year;
    int month;
    int day;
}*/
class Citizen{
    String name;//姓名
    MyDate birthday;//生日   MyDate虽然是自己写的类，但是也可以作为Java的数据类型
    String cardId;//身份证号
}