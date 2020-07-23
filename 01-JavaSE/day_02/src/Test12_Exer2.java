/**
 * @author Liu Awen
 * @create 2018-05-07 22:03
 */
class Test12_Exer2{
    public static void main(String[] args){
        int x = 1;
        int y = 1;
		/*
		第一步：x++
		(1)先取x的值“1”
		(2)再x自增x = 2
		第二步：比较
		用“1”与2比较， 1==2，不成立，false

		因为&&是短路与，左边为false，右边就不看了



		第三步：逻辑
		false & ？，结果为false，总的if不成立
		*/
		//x=1 y=1
        if(x++ == 2 && ++y==2){
            x = 7;
        }
        System.out.println("x = " + x + ",y = " + y);//x = 2,y = 1
    }
}