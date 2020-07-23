package test11;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明学生类，
（1）有属性：姓名，年龄，成绩，并且私有化，
（2）提供公共的get/set。
（3）提供getInfo()方法，返回学生对象的信息
2、在测试中用set方法赋值，用getInfo()返回学生信息
*/
class Test11_Exer4{
    public static void main(String[] args){
        Student stu = new Student();
        stu.setName("张三");
        //stu.setName = "张三";//错误的
        stu.setAge(23);
        stu.setScore(80);

        System.out.println(stu.getInfo());
    }
}
class Student{
    private String name;
    private int age;
    private double score;

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

    //提供getInfo()方法，返回学生对象的信息
    public String getInfo(){
        return "姓名：" + name + "，年龄：" + age + "，成绩：" + score;
    }
}