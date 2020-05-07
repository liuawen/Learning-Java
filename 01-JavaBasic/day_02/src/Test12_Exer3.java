/**
 * @author Liu Awen
 * @create 2018-05-07 22:03
 */
class Test12_Exer3{
    public static void main(String[] args){
        int x = 1;
        int y = 1;
		/*
		第一步：x++
		(1)先取x的值“1”
		(2)再x自增x = 2
		第二步：比较
		用“1”与1比较， 1==1，成立，true

		中间是|，不是短路或，右边要继续
		第三步：++y
		(1)y先自增，y=2
		(2)再去y的值“2”
		第四步：比较
		用“2”与1比较  2==1，不成立，结果为false


		第五步：逻辑
		true & false，结果为true，总的if成立，要执行x = 7
		*/
		//
        if(x++ == 1 | ++y==1){
            x = 7;
        }
        System.out.println("x = " + x + ",y = " + y);//x = 7,y = 2
    }
}