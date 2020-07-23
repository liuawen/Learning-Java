/**
 * @author Liu Awen
 * @create 2018-05-07 22:03
 */
class Test13_Exer{
    public static void main(String[] args){
        boolean x = true;
        boolean y = false;
        short z = 42;
		/*
		第一步：z++
		(1)先取z的值“42”
		(2)z自增 z=43
		第二步：比较
		用“42”与42比较，条件成立，true

		中间是&&，短路与，但是没有满足短路现象。右边继续
		第三步：
		取y的值false
		第四步：
		比较，用"false"与true比较，条件不成立，false
		第五步：
		true && false，结果为false，if条件不成立，z++不执行
		*/
        if((z++==42) && (y==true))
            z++;

		/*
		||左边：x=false，这是赋值运算，结果仍然是false
		中间||，是短路或，但是没有满足短路现象，右边继续
		右边：
		++z：先自增z=44，然后取z的值“44”，然后与45进行比较，结果为false
		左边的false || 右边的false，结果还是false，if不成立，z++不执行
		*/
        if((x=false) || (++z==45))
            z++;
        System.out.println("z = " + z);//44
    }
}