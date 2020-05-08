/**
 * @author Liu Awen
 * @create 2018-05-08 18:54
 */
/*
循环的嵌套：

执行过程：外循环循环一次，内循环整个循环一轮

例如：
*****
*****
*****
*****
*/
class Test15_NestLoop{
    public static void main(String[] args){
        for(int i=1; i<=4; i++){
            //System.out.println("*****");
			/*
			上面的语句做了两件事：
			（1）连续打印5颗*
			（2）换行
			*/
            //（1）连续打印5颗*
            for(int j=1; j<=5; j++){
                System.out.print("*");
            }

            //（2）换行
            System.out.println();
        }
		/*
		（1）执行外循环的int i=1;
		（2）执行外循环的i<=4;
		（3）条件成立执行外循环的循环体语句
			for(int j=1; j<=5; j++){
				System.out.print("*");
			}
			System.out.println();
			（4）执行内循环的int j=1;
			（5）执行内循环的j<=5;
			（6）条件成立，执行内循环的循环体语句  System.out.print("*");
			（7）执行内循环的迭代语句 j++  j=2
			（8）执行内循环的j<=5;
			（9）条件成立，执行内循环的循环体语句  System.out.print("*");
			（10）执行内循环的迭代语句 j++  j=3
			（11）执行内循环的j<=5;
			（12）条件成立，执行内循环的循环体语句  System.out.print("*");
			（13）执行内循环的迭代语句 j++  j=4
			（14）执行内循环的j<=5;
			（15）条件成立，执行内循环的循环体语句  System.out.print("*");
			（16）执行内循环的迭代语句 j++  j=5
			（17）执行内循环的j<=5;
			（18）条件成立，执行内循环的循环体语句  System.out.print("*");
			（19）执行内循环的迭代语句 j++  j=6
			（20）执行内循环的j<=5;
			（21）内循环条件不成立，结束内循环

			（22）System.out.println();  它是属于外循环的循环体语句
		（23）执行外循环的迭代语句i++  i=2
		（24）执行外循环的i<=4;
		（25）条件成立，再次执行外循环的循环体语句
			for(int j=1; j<=5; j++){
				System.out.print("*");
			}
			System.out.println();

			（26）内循环再来一轮  j=1,j=2,j=3,j=4,j=5  打印5个*
			（27）System.out.println();
		（28）执行外循环的迭代语句i++  i=3
			。。。。。。
		*/
    }
}