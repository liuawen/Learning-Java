/**
 * @author Liu Awen
 * @create 2018-05-08 11:00
 */
/*
值：数据
变量：用来保存/存储值
表达式：
	用来计算的
语句：
	可以独立执行的，并且是要完成一件事情的。
	不是所有的表达式直接加;就可以构成语句的。
语句  有意义的  独立执行  要完成一件事情的

流程控制语句结构：
1、顺序结构（每一步都要走，而且从上往下顺着走）
2、分支结构（选择其中一个分支运行）
3、循环结构（重复执行某些语句）
顺序 shun xu 一步步执行
选择 分支  选择一个走执行
循环  重复执行一些语句
*/
class Test01_Statement{
    public static void main(String[] args){
        int a = 10;
//        a;//Error:(22, 9) java: 不是语句
        //a;//没有意义，什么也没干
        //你这干了什么吗  有啥意义  要有事做
        //a>0?true:false;//这个表达式算完后，没有做具体的事情，例如：打印还是赋值等这些事情
        System.out.println("a = " + a);

        if(a%2==0){
            System.out.println(a+"是偶数");
        }else{
            System.out.println(a+"是奇数");
        }

        for(int i=1; i<=5; i++){
            System.out.println("柳江雪老师真漂亮！");
            System.out.println("超级喜欢你呢！");
        }
    }
}
