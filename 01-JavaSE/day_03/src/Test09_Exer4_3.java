/**
 * @author Liu Awen
 * @create 2018-05-08 11:40
 */
/*
4、大家都知道，男大当婚，女大当嫁。那么女方家长要嫁女儿，
当然要提出一定的条件：高：180cm以上；富：财富1千万以上；帅：是。
如果这三个条件同时满足，则：“我一定要嫁给他!!!”
如果三个条件中有为真的情况，则：“嫁吧，比上不足，比下有余。”
如果三个条件都不满足，则：“不嫁！”
提示：从键盘输入
Scanner input=new Scanner(System.in);
input.nextInt();//接收从键盘输入的一个整数
input.next();输入一个字符串
input.nextDouble();//输入一个小数
input.nextBoolean();//输入一个布尔值
*/
class Test09_Exer4_3{
    public static void main(String[] args){
        //1、输入男方的条件
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("请输入身高（单位：cm）：");
        int height = input.nextInt();

        System.out.print("请输入财富（单位：千万）：");
        double money  = input.nextDouble();

        System.out.print("请输入是否帅（帅/不帅）：");
        String handsom = input.next();

        //2、判断
		/*
		高：180cm以上；富：财富1千万以上；帅：是。
		如果这三个条件同时满足，则：“我一定要嫁给他!!!”
		如果三个条件中有为真的情况，则：“嫁吧，比上不足，比下有余。”
		如果三个条件都不满足，则：“不嫁！”
		handsom=="帅" 是不对的  == ！= 比较引用数据类型的比较 用于比较对象的地址
		"帅".equals(handsom) 是可以的，String对象的比较
		*/
        if(height>=180 && money>=1 && "帅".equals(handsom)){
            System.out.println("我一定要嫁给他!!!");
        }else if(height>=180 || money>=1 || "帅".equals(handsom)){
            System.out.println("嫁吧，比上不足，比下有余。");
        }else{
            System.out.println("不嫁！");
        }
    }
}
