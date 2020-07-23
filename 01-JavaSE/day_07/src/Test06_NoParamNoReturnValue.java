/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
方法的原则：
（1）必须先声明后使用
（2）不调用不执行

一、无参无返回值的方法
1、如何声明
【修饰符】 void 方法名(){
	方法体
}
2、调用
（1）在本类中，同一个级别，直接调用
	方法名();

（2）在其他类中，需要通过"对象名.方法"
	对象名.方法名();

*/
class Test06_NoParamNoReturnValue{
    public static void main(String[] args){
        //1、创建对象
        Student s1 = new Student();

        //2、通过对象去调用方法
        s1.printInfo();

        //3、给属性赋值
        s1.name = "杨洪波";
        s1.age = 23;
        s1.score = 100;

        //4、再次调用s1对象的printInfo()
        s1.printInfo();

        //int a = s1.printInfo();//错误的，无返回值
        //System.out.println(s1.printInfo());//错误的，无返回值
    }
}
class Student{
    //属性
    String name;
    int age;
    int score;

    //方法
    //省略修饰符
    //1、声明一个方法，可以打印当前学生对象的信息
    void printInfo(){
        System.out.println("姓名：" + name + ",年龄：" +age + ",成绩：" + score);
    }

    //void test(){
    //	printInfo();
    //}
}
