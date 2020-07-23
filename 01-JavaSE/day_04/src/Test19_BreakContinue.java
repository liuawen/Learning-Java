/**
 * @author Liu Awen
 * @create 2018-05-08 22:50
 */
/*
break：
（1）用于switch...case
作用：结束switch
（2）用于循环结构
作用：结束当前循环
说明：
	如果break在内循环中，结束的内循环；
	如果break在内循环外，外循环内，结束的是外循环

如果要用break结束外循环，可以给外循环取一个标签名（了解）
*/
class Test19_BreakContinue{
    public static void main(String[] args){
		/*
		外循环：i=1,2,3,4,5
		*/
        for(int i=1; i<=5; i++){
			/*
			当i=1,j=1  内循环执行1次就结束
			当i=2,j=1,2  内循环执行2次就结束
			当i=3,j=1,2,3  内循环执行3次就结束
			当i=4,j=1,2,3,4  内循环执行4次就结束
			当i=5,j=1,2,3,4,5   内循环执行5次就结束
			*/
            for(int j=1; j<=5; j++){
                System.out.print("*");
                if(i==j){
                    break;
                }
            }
            System.out.println();
            //*
            //**
            //***
            //****
            //*****
        }
    }
}