package test09;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
练习2
（1）声明一个学生类Student，包含姓名name和成绩score属性
（2）在测试类TestStudentArray中创建一个长度为3的学生数组
（3）从键盘输入为学生对象的姓名和成绩属性赋值
（4）遍历显示学生信息
（5）使用冒泡排序对数组按照学生成绩从低到高排序
（6）再次遍历显示学生信息
*/
class Test09_Exer3{
    public static void main(String[] args){
        //创建一个长度为3的学生数组
        Student[] all = new Student[3];

        //从键盘输入为学生对象的姓名和成绩属性赋值
        java.util.Scanner input = new java.util.Scanner(System.in);
        for(int i=0; i<all.length; i++){
            System.out.println("请输入第" + (i+1) + "个学员的信息：");

            //创建这个学生对象
            all[i] = new Student();

            System.out.print("姓名：");
            all[i].name = input.next();

            System.out.print("成绩：");
            all[i].score = input.nextInt();
        }

        //遍历显示学生信息
        for(int i=0; i<all.length; i++){
            //all[i].printInfo();
            System.out.println(all[i].getInfo());
        }

        //使用冒泡排序对数组按照学生成绩从低到高排序
        for(int i=1; i<all.length; i++){//控制轮数

            //从低到高，把大的往右移动
			/*
			当i=1, j=0,1  all[0]与all[1]  all[1]与all[2]
			当i=2，j=0    all[0]与all[1]
			all[j] 与 all[j+1]
			*/
            for(int j=0; j<all.length-i; j++){
                //all[j]是一个学生对象
                //if(all[j] > all[j+1]){//二元运算符 '>' 的操作数类型错误
                if(all[j].score > all[j+1].score){
                    //交换两个元素，不是交换两个人的成绩
                    Student temp = all[j];//all[j]是一个Student
                    all[j] = all[j+1];
                    all[j+1] = temp;
                }
            }

        }

        //遍历显示学生信息
        for(int i=0; i<all.length; i++){
            //all[i].printInfo();
            System.out.println(all[i].getInfo());
        }
    }
}
class Student{
    String name;
    int score;

    void printInfo(){
        System.out.println("姓名：" + name + "，成绩：" + score);
    }
    String getInfo(){
        return "姓名：" + name + "，成绩：" + score;
    }
}
