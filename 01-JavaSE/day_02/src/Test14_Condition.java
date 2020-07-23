/**
 * @author Liu Awen
 * @create 2018-05-07 22:16
 */
/*
运算符：
5、条件运算符，
因为它是唯一的三元运算符，所以也称为三元运算符

条件表达式 ？ 结果表达式1 ： 结果表达式2

整个表达式包含三个部分。
运算规则：如果条件表达式成立，就取结果表达式1的值，否则就取结果表达式2的值

*/
class Test14_Condition{
    public static void main(String[] args){
        boolean marry = false;
        System.out.println(marry ? "已婚" : "未婚");

        //找出x和y中的最大值
        int x = 4;
        int y = 4;
        int max = x>=y ? x : y;
		/*
		等价于
		if(x>=y){
			max = x;
		}else{
			max = y;
		}
		*/
        System.out.println(x + "，" + y + "中的最大值是：" + max);
        int a = 4;
        int b = 5;
        int m;
        if (a >= b){
            m = a;
        }else{
            m = b;
        }
        System.out.println(a + ","+  + b + ","+"m:" + m);
        int temp = a;
        a = b;
        b = temp;
        m = a>=b ? a : b;
        System.out.println();
        System.out.println(a + ","+  + b + ","+"m:" + m);


    }
}