package homework;

/**
 * @author Liu Awen
 * @create 2020-05-16 8:34
 */
/*
需求：保存全班的每个组的成绩，并对成绩做统计

1. 从键盘输入一共有几组
2. 从键盘输入每一组分别有多少人
3. 从键盘输入每一个同学的成绩
4. 统计每一组的最高分、最低分
5. 统计每一组的平均分
6. 统计全班的最高分、最低分
7. 统计全班的平均分
8. 统计全班的总人数
*/
class Day06_Test06{
    public static void main(String[] args){
        java.util.Scanner input = new java.util.Scanner(System.in);

        //(1)从键盘输入一共有几组，确定二维数组的行数
        System.out.print("请输入一共有几组：");
        int group = input.nextInt();

        //(2)创建二维数组，并确定行数
        int[][] arr = new int[group][];

        //(3)从键盘输入每一组分别有多少人，确定每一行的列数
        for(int i=0; i<arr.length; i++){
            System.out.print("请输入第" + (i+1) + "组有几个人:");
            arr[i] = new int[input.nextInt()];

            //(4)从键盘输入每一个同学的成绩
            for(int j = 0; j<arr[i].length; j++){
                System.out.print("请输入第" + (j+1) + "个组员的成绩：");
                arr[i][j] = input.nextInt();
            }
        }

        //(4)显示成绩表
        System.out.println("每组成绩如下：");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

		/*
		4. 统计每一组的最高分、最低分
		5. 统计每一组的平均分
		6. 统计全班的最高分、最低分
		7. 统计全班的平均分
		8. 统计全班的总人数
		*/
        int[] groupMax = new int[group];//有几组就有几个元素
        int[] groupMin = new int[group];
        double[] groupAvg = new double[group];
        int max = -1;//全班的最高分
        int min = 101;//全班的最低分，假设成绩的范围是[0,100]
        double sum = 0;
        int count = 0 ;

        //把每一组的最高分，最低分，都初始化为特殊值
        for(int i=0; i<group; i++){
            groupMax[i] = -1;
            groupMin[i] = 101;
        }

        //统计
        for(int i=0; i<arr.length; i++){
            double groupSum = 0;//每一组累加总分，都是从0开始
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] > groupMax[i]){//找每组的最高分
                    groupMax[i] = arr[i][j];
                }
                if(arr[i][j] < groupMin[i]){//找每组的最低分
                    groupMin[i] = arr[i][j];
                }
                if(arr[i][j] > max){//找全班的最高分
                    max = arr[i][j];
                }
                if(arr[i][j] < min){//找全班的最低分
                    min = arr[i][j];
                }
                groupSum += arr[i][j];//累加每一组的总分
                sum += arr[i][j];//累加全部的总分
                count++;//累加总人数
            }

            //每一组的平均分 = 每一组的总分/每一组的人数
            groupAvg[i] = groupSum / arr[i].length;
        }

        //全部的平均分 = 全部的总分 / 总人数
        double avg = sum / count;

        System.out.println("全班的最高分：" + max);
        System.out.println("全班的最低分：" + min);
        System.out.println("全班的平均分：" + avg);
        System.out.println("全班的总人数：" + count);
        for(int i=0; i<arr.length; i++){
            System.out.println("第" + (i+1) + "组的最高分：" + groupMax[i]);
            System.out.println("第" + (i+1) + "组的最低分：" + groupMin[i]);
            System.out.println("第" + (i+1) + "组的平均分：" + groupAvg[i]);
        }
    }
}