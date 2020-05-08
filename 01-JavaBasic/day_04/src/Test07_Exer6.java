/**
 * @author Liu Awen
 * @create 2018-05-08 14:45
 */
/*
6、从1循环到150并在每行打印一个值，
另外在每个3的倍数行上打印出“foo”,在每个5的倍数行上打印“biz”,
在每个7的倍数行上打印输出“baz”。
*/
class Test07_Exer6{
    public static void main(String[] args){
        //从1循环到150
        for(int i=1; i<=150; i++){
            //在每行打印一个i的值
            //System.out.println(i);//输出i之后，立刻换行
            System.out.print(i);//只打印i的值

            //每个3的倍数行上打印出“foo”
            if(i%3==0){
                //System.out.println("foo");//输出foo后立刻换行
                System.out.print("\tfoo");//这里加\t是为了好看
            }

            //在每个5的倍数行上打印“biz”
            if(i%5==0){
                System.out.print("\tbiz");
            }

            //在每个7的倍数行上打印输出“baz”
            if(i%7==0){
                System.out.print("\tbaz");
            }

            //最后把这一行的事全部完成后，再换行
            //System.out.print("\n");
            System.out.println();//只打印换行
        }
    }
}
