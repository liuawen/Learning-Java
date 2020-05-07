/**
 * @author Liu Awen
 * @create 2018-05-07 22:14
 */
class Test13_Exer2{
    public static void main(String[] args){
        boolean x = true;
        boolean y = false;
        short z = 42;


		/*
		这里y=true是赋值，结果还是true,表示条件成立，并且y的值已经变为true
		*/
        if(y=true)
		/*
		第一步：z++
		(1)先取z的值“42”
		(2)z自增 z=43
		第二步：比较
		用“42”与42比较，条件成立，true

		中间是&&，短路与，但是没有满足短路现象。右边继续
		第三步：
		取y的值true
		第四步：
		比较，用"true"与true比较，条件成立，true
		第五步：
		true && true，结果为true，if条件成立，z++执行
		z = 44
		*/
            if((z++==42) && (y==true))
                z++;

		/*
		||左边：x=false，这是赋值运算，结果仍然是false
		中间||，是短路或，但是没有满足短路现象，右边继续
		右边：
		++z：先自增z=45，然后取z的值“45”，然后与45进行比较，结果为true
		左边的false || 右边的true，结果还是true，if成立，z++执行，z=46
		*/
        if((x=false) || (++z==45))
            z++;
        System.out.println("z = " + z);//46
    }
}