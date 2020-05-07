/**
 * @author Liu Awen
 * @create 2018-05-07 17:01
 * 下午来了  上午的搞定 但时间已经到了下午五点钟了
 */
/*
运算符：
3、比较运算符
大于：>
小于：<
大于等于：>=
小于等于：<=
等于：==
	注意，谨防与赋值的=混淆
不等于：!=

比较运算符，计算完后的结果只有两个：true,false
说明比较运算符的表达式，可以作为（1）判断的条件（2）逻辑运算符的操作数

比较运算符能够用于基本数据类型，不能用于引用数据类型。
除了==和!=，关于引用数据类型时它俩的意义后面再讲。

一元运算符：操作数只有一个
	例如：a++  其中a就是操作数
		-a   其中a就是操作
二元运算符：需要两个操作数
	例如：求和   a+b  其中a和b就是操作
		  比较大小  age>=18  其中的age和18都是操作数
三元运算符：需要三个操作数
	...
*/
class Test10_Compare{
    public static void main(String[] args){
		/*
		有一个变量age,表示年龄，判断是否成年（满足18岁）

		*/
        int age = 26;

        System.out.println("是否成年：" + (age>=18));

		/*
		比较运算符作为条件
		*/
        if(age >= 18){
            System.out.println("祝你玩得愉快！");
        }else{
            System.out.println("未成年不得进入！");
        }

		/*
		有一个变量，存储的是boolean类型的值
		*/
        boolean flag = false;
        if(flag == true){//不会修改flag里面的值
            System.out.println("条件成立");
        }
        //与上面的语句是等价的
        if(flag){
            System.out.println("条件成立");
        }

        if(flag = true){//不是比较，而是赋值，结果仍然是布尔值，只要是布尔值就可以作为条件
            System.out.println("条件成立");
        }
        System.out.println("flag = " + flag);

		/*
		有一个变量，存储的是其他类型的值
		*/
        int num = 1;
        if(num == 1){
            System.out.println("num=1");
        }

        //if(num = 1){//错误的，因为num=1是赋值表达式，结果还是int，int值是不能作为条件的
        //	System.out.println("num=1");
        //}
    }
}