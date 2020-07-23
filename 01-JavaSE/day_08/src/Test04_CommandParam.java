/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
命令行参数：(了解)
	给main方法传的实参，叫做命令行参数
格式：
	java main所在的类名  实参1  实参2 ...
例如：
	java  Test04_CommandParam  hello java hehe world
*/
class Test04_CommandParam{
    /*
    因为main也是一个有参无返回值的方法，那么如何给main传参数呢？
    */
    public static void main(String[] args){
        //args是形参，是String[]类型，是一个一维数组
        for(int i=0; i<args.length; i++){
            System.out.println("第" +(i+1) +"个参数的值：" + args[i]);
        }
    }
}