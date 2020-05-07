/**
 * @author Liu Awen
 * @create 2018-05-07 22:03
 */
class Test12_Exer1{
    public static void main(String[] args){
        int x = 1;
        int y = 1;
		/*
		第一步：x++
		(1)先取x的值“1”
		(2)再x自增x = 2
		第二步：比较
		用“1”与2比较， 1==2，不成立，false

		因为&不是短路与，不管左边是怎么样，右边继续

		第三步：++y
		(1)自增 y = 2
		(2)取y的值“2”
		第四步：比较
		用“2”与2比较  2 == 2,成立，true

		第五步：逻辑
		false & true，结果为false，总的if不成立
		*/
        if(x++ == 2 & ++y==2){
            x = 7;
        }
        //&  两个都要处理的
        System.out.println("x = " + x + ",y = " + y);//x = 2,y = 2
    }
}
