/**
 * @author Liu Awen
 * @create 2018-05-09 22:44
 */
/*
2、数组的练习2：
	用一个数组，保存平年1-12月的满月天数，并且遍历显示结果：
	1月：31天
	2月：28天
	...
*/
class Test04_Exer2{
    public static void main(String[] args){
        //用一个数组，保存平年1-12月的满月天数，
        int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        //并且遍历显示结果
        for(int i=0; i<daysOfMonth.length; i++){
            System.out.println((i+1) + "月：" + daysOfMonth[i]);
        }
    }
}