/**
 * @author Liu Awen
 * @create 2018-05-07 19:57
 */
/*
运算符：
4、逻辑运算符
逻辑与：&
	类似于：且
	true & true 结果为true
	true & false 结果为false
	false & true 结果为false
	false & false 结果为false

多个条件是否两个都成立 两个都满足的
逻辑或：|
	类似于：或
	true | true 结果为true
	true | false 结果为true
	false | true 结果为true
	false | false 结果为false
	满足一个  为true
逻辑非：!
	类似于：取反
	!true 结果为false
	!false 结果为true
逻辑异或：^
	类似于：求不同
	true ^ true 结果为false
	true ^ false 结果为true
	false ^ true 结果为true
	false ^ false 结果为false
	求不同  不同的为true   一样的为false
短路与：&&
	结果：和&是一样的
	运算规则：如果&&的左边已经是false，右边就不看了
	true & true 结果为true
	true & false 结果为false
	false & ? 结果为false
	false & ? 结果为false
	段路运算
短路或：||
	结果：和|是一样的
	运算规则：如果||左边已经是true，右边就不看了
	true | ？ 结果为true
	true | ？ 结果为true
	false | true 结果为true
	false | false 结果为false
*/
class Test11_Logic{
    public static void main(String[] args){
		/*
		判断成绩是否在70和80之间
		数学：70<=score<=80
		Java中：
		*/
        int score = -78;

		/*
		Test11_Logic.java:14: 错误: 二元运算符 '<=' 的操作数类型错误
                if( 70<=score<=80){
                             ^
		  第一个类型:  boolean   70<=score的运算结果是true或false
		  第二个类型: int
		1 个错误
		false<=80 int
		*/
        //if( 70<=score<=80){
        //	System.out.println("良好");
        //}

        if(70<=score & score<=80){
            System.out.println("良好");
        }

		/*
		假设成绩合理范围[0,100]
		判断成绩是否小于0 或 大于100，输出成绩有误
		*/
        if(score<0 | score>100){
            System.out.println("成绩有误");
        }

		/*
		假设成绩合理范围[0,100]
		判断成绩是否在合理范围内
		*/
        if(score>=0 & score<=100){

        }
        //或下面这么写
        if(!(score<0 | score>100)){

        }

        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(false ^ false);

		/*
		短路与：&&
		短路或：||
		*/
        int i = 1;
        int j;
		/*
		第一步：i++
		(1)先取i的值“1”，放起来
		(2)在i自增,i=2
		第二步：算比较
		放起来的“1” == 1比较，成立
		&&左边是true，不会短路
		第三步：++i
		(1)先自增i=3
		(2)再取i的值“3”，放起来
		第四步：比较
		放起来的“3” == 2比较，结果是false，不成立
		第五步：
		左边的true && 右边的false运算，结果为false，总的if不成立，走else
		*/
        //if(i++ == 1 && ++i == 2){
        //	j = 1;
        //}else{
        //	j = 2;
        //}

		/*
		第一步：i++
		(1)先取i的值“1”，放起来
		(2)在i自增,i=2
		第二步：算比较
		放起来的“1” == 1比较，成立
		||左边是true，会发生短路，右边不看了（++i == 2）没运算

		第三步：
		true || ?，结果为true,总的if成立
		*/
        if(i++ == 1 || ++i == 2){
            j = 1;
        }else{
            j = 2;
        }
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }
}
