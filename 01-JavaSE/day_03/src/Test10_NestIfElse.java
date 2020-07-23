/**
 * @author Liu Awen
 * @create 2018-05-08 12:54
 */
/*
二、分支结构
1、条件判断：if..else
2、选择结构：switch...case

（一）条件判断
1、单分支条件判断
2、双分支条件判断
3、多分支条件判断
4、嵌套条件判断
语法格式：
在if(){
	出现了条件判断
}
或在else{
	出现了条件判断
}

当嵌套时，里面的条件判断要被执行的前提，外面的if或else要先满足。
嵌套 一个套一个 嵌套很多种
*/
class Test10_NestIfElse{
    public static void main(String[] args){

		/*从键盘输入成绩：合法[0,100]之间
		成绩分为：
			100分，输出满分
			90-99，输出优秀
			70-89，输出良好
			60-69，输出及格
			60以下，输出不及格
		*/
        //1、输入成绩
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入成绩：");
        int score = input.nextInt();

        //2、判断
        if(score>=0 && score<=100){
            //再去判断是哪个等级的
            if(score == 100){
                System.out.println("满分");
            }else if(score>=90 && score<=99){
                System.out.println("优秀");
            }else if(score>=70 && score<=89){
                System.out.println("良好");
            }else if(score>=60 && score<=69){
                System.out.println("及格");
            }else{
                System.out.println("不及格");
            }
        }else{
            System.out.println("成绩输入有误，成绩范围：[0,100]");
        }
    }
}






