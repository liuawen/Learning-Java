package homework;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
案例：

?	1、声明一个Employee员工类，
?		包含属性：编号(id)、姓名(name)、薪资(salary)、年龄(age)
?		包含方法：
?		（1）void printInfo()：可以打印员工的详细信息
?		（2）void setInfo(int  i, String n, double s, int a)：可以同时给id,name,salary,age赋值
?	2、声明一个TestEmployee测试类，
?	（1）public static void main(String[] args)：
	在main方法中，创建Employee[]数组，并创建5个员工对象放到数组中，
	并为员工对象的属性赋值
?	（2）public static void print(Emplyee[] all)：遍历打印员工数组中的每个员工的详细信息，并在main中调用
?	（3）public static void sort(Employee[] all)：将all员工数组按照年龄从高到低排序，并在main中调用测试
?	（4）public static void addSalary(Employee[] all, double increament)：将all员工数组的每一个员工的工资，增加increament，并在main中调试测试
*/

class Day08_Test05{
    public static void main(String[] args){
        Employee[] all = new Employee[5];
        all[0] = new Employee();
        all[0].setInfo(1,"张三",10000,23);

        all[1] = new Employee();
        all[1].setInfo(2,"李四",12000,23);

        all[2] = new Employee();
        all[2].setInfo(3,"王五",8000,18);

        all[3] = new Employee();
        all[3].setInfo(4,"赵六",6000,20);

        all[4] = new Employee();
        all[4].setInfo(5,"钱七",15000,21);

        print(all);
        sort(all);
        System.out.println("------------------------------------------");
        print(all);

        addSalary(all, 200);
        System.out.println("------------------------------------------");
        print(all);
    }

    public static void print(Employee[] all){
        for(int i=0; i<all.length; i++){
            all[i].printInfo();
        }
    }
    //年龄排序 大到小排序
    public static void sort(Employee[] all){
        for(int i=1; i<all.length; i++){
            for(int j=0; j<all.length-i; j++){
                //从高到低
                if(all[j].age < all[j+1].age){
                    Employee temp = all[j];
                    all[j] = all[j+1];
                    all[j+1] = temp;
                }
            }
        }
    }

    public static void addSalary(Employee[] all, double increament){
        for(int i=0; i<all.length; i++){
            all[i].salary += increament;
        }
    }
}
class Employee{
    int id;
    String name;
    double salary;
    int age;

    void printInfo(){
        System.out.println("编号：" + id + "，姓名：" + name + "，薪资：" + salary + "，年龄：" +age);
    }
    void setInfo(int  i, String n, double s, int a){
        id = i;
        name = n;
        salary = s;
        age = a;
    }
}