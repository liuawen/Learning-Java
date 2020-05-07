/**
 * @author Liu Awen
 * @create 2018-05-07 22:03
 */
class Test12_Exer4{
    public static void main(String[] args){
        int x = 1;
        int y = 1;
		/*
		第一步：x++
		(1)先取x的值“1”
		(2)再x自增x = 2
		第二步：比较
		用“1”与1比较， 1==1，成立，true

		中间是||，是短路或，左边已经为true,会发生短路现象，右边不看了


		第五步：逻辑
		true & ？，结果为true，总的if成立，要执行x = 7
		*/
		// x = 1  ; y =1
        if(x++ == 1 || ++y==1){
            x = 7;
        }
        System.out.println("x = " + x + ",y = " + y);//x = 7,y = 1
    }
}