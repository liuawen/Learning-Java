package homework;

/**
 * @author Liu Awen
 * @create 2018-05-09 22:12
 */
/*
 * * * * *
 * * * *
 * * *
 * *
 *

 */
class Day04_Test07{
    public static void main(String[] args){
        for(int i=1; i<=5; i++){//控制行数
			/*
			每一行有三件事：
			（1）打印n个空格
			（2）打印m个" *"
			（3）换行
			*/
            //（1）打印n个空格
			/*
			第1行：0个，当i=1, j应该让它第一次循环都不满足	j<i
			第2行：1个，当i=2, j运行1次，j=1
			第3行：2个，当i=3, j运行2次，j=1,2
			第4行：3个，当i=4, j运行3次，j=1,2,3
			第5行：4个，当i=5, j运行4次，j=1,2,3,4
			*/
            for(int j=1; j<i; j++){
                System.out.print(" ");
            }
            //（2）打印m个" *"
			/*
			第1行：5个，当i=1,j运行5次，j=1,2,3,4,5		j<=6-i
			第2行：4个，当i=2,j运行4次，j=1,2,3,4
			第3行：3个，当i=3,j运行3次，j=1,2,3
			第4行：2个，当i=4,j运行2次，j=1,2
			第5行：1个，当i=5,j运行1次，j=1
			*/
            for(int j=1; j<=6-i; j++){
                System.out.print(" *");
            }


            //（3）换行
            System.out.println();
            // * * * * *
            //  * * * *
            //   * * *
            //    * *
            //     *
            //
            //Process finished with exit code 0
        }
    }
}
