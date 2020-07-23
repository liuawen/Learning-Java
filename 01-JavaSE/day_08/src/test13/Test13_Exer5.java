package test13;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明学生类，
（1）有属性：姓名，年龄，成绩，并且私有化，
（2）提供有参和无参构造
（3）提供公共的get/set。
（4）提供getInfo()方法，返回学生对象的信息
2、在测试中
（1）用有参和无参构造分别创建对象
（2）用set方法修改属性值
（3）用getInfo()返回学生信息

习惯上：
类{
	属性列表;

	构造器列表;

	方法列表;
}
*/
class Test13_Exer5{
    public static void main(String[] args){
        //1、无参构造创建对象
        Student s1 = new Student();
        //s1.setName = "张三";//错误的
        s1.setName("张三");
        s1.setAge(23);
        s1.setScore(89);
        System.out.println(s1.getInfo());

        //2、有参构造创建对象
        Student s2 = new Student("李四",24, 34);
        System.out.println(s2.getInfo());
        s2.setScore(74);//修改成绩的值
        System.out.println(s2.getInfo());
    }
}
class Student{
    private String name;
    private int age;
    private double score;

    public Student(){

    }
    public Student(String n, int a, double s){
        name = n;
        age = a;
        score = s;
    }

    //提供公共的get/set。
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setAge(int a){
        age = a;
    }
    public int getAge(){
        return age;
    }
    public void setScore(double s){
        score = s;
    }
    public double getScore(){
        return score;
    }

    public String getInfo(){
        return "姓名：" + name + "，年龄:" + age +"，成绩：" +score;
    }
}