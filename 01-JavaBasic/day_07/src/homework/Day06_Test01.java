package homework;

/**
 * @author Liu Awen
 * @create 2020-05-16 8:28
 */
//注释写代码
//根据注释来写代码  去掉注释写代码  写注释+代码
/*
案例：从键盘输入本组学员的人数，
和本组学员的成绩，用数组存储成绩，然后实现从高到低排序
*/
class Day06_Test01{
    public static void main(String[] args){
        java.util.Scanner input = new java.util.Scanner(System.in);

        //(1)先确定人数，即确定数组的长度
        //叫用户输入小组的个数
        System.out.print("请输入本组学员的人数：");
        int count = input.nextInt();

        //(2)创建数组
        int[] scores = new int[count];

        //(3)输入学员的成绩
        for(int i=0; i<scores.length; i++){
            System.out.print("请输入第" +(i+1)+"个学员的成绩：");
            scores[i] = input.nextInt();
        }

        //(4)排序，冒泡
        for(int i=1; i<scores.length; i++){
            //从高到低，即从大到小
            //例如：5个人
            //从左到右，j的起点是0，
            //终点是3,2,1,0
            //arr[j] 与arr[j+1]
            for(int j=0; j<scores.length-i; j++){
                if(scores[j] < scores[j+1]){
                    int temp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = temp;
                }
            }
        }

        //(5)显示结果
        for(int i=0; i<scores.length; i++){
            System.out.print(scores[i]+ " ");
        }
    }
}