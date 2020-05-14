/**
 * @author Liu Awen
 * @create 2018-05-10 16:57
 */
/*
1、数组的练习
用一个数组存储本组学员的成绩，并遍历显示
（1）其中学员的人数从键盘输入
（2）学员的成绩从键盘输入
*/
class Test08_Exer4{
    public static void main(String[] args){
		/*
		步骤：
		1、先确定人数，从键盘输入
		2、声明并创建数组，用来存储成绩
		3、确定每一个成绩：为每一个元素赋值
		4、遍历显示
		*/

        //1、先确定人数，从键盘输入
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入本组的人数：");
        int count = input.nextInt();

        //2、声明并创建数组，用来存储成绩
        //int[] scores = new int[长度];
        int[] scores = new int[count];

        //3、确定每一个成绩：为每一个元素赋值
        for(int i=0; i<count; i++){
            System.out.print("请输入第"+ (i+1) + "个学员的成绩：");
            //为元素赋值：为谁赋值，就把谁写在=的左边
            scores[i] = input.nextInt();//用键盘输入的值为元素赋值
        }

        //4、遍历显示
        System.out.println("本组学员的成绩如下：");
        for(int i=0; i<scores.length; i++){
            System.out.print(scores[i]+"\t");//  \t 制表符
        }
        //请输入本组的人数：5
        //请输入第1个学员的成绩：1
        //请输入第2个学员的成绩：2
        //请输入第3个学员的成绩：3
        //请输入第4个学员的成绩：4
        //请输入第5个学员的成绩：5
        //本组学员的成绩如下：
        //1	2	3	4	5
        //Process finished with exit code 0
    }
}