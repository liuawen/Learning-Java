/**
 * @author Liu Awen
 * @create 2018-05-10 20:19
 */
/*
数组的相关的算法操作：
1、在数组中找最大值/最小值
2、在数组中找最大值/最小值及其下标
3、数组的元素累加和及平均值
求最大最小值
求最大最小的下标
累加及平均值
sum  avg
*/
class Test13_SumAndAvg{
    public static void main(String[] args){
		/*
		有一组学员的成绩存储在数组中，统计总分和平均分
		*/
        int[] scores = {78,89,56,99,100};

        //求总分
        int sum = 0;
        for(int i=0; i<scores.length; i++){
            sum += scores[i];
        }

        //求平均值
        double avg = (double)sum / scores.length;
        System.out.println("总分：" + sum);
        System.out.println("人数：" + scores.length);
        System.out.println("平均分：" + avg);

    }
}