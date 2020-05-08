/**
 * @author Liu Awen
 * @create 2018-05-08 15:54
 */
/*
4、随机生成一个100以内的整数，猜数字游戏
从键盘输入数，如果大了提示，大了，如果小了，提示小了，如果对了，就不再猜了，
并统计一共猜了多少次
*/
class Test09_Exer4{
    public static void main(String[] args){
        //随机生成一个100以内的整数,[0,100)
		/*
		Math.random() -->[0,1)的小数
		Math.random()*100 -->[0,100)的小数
		[0,100)的整数 (int)(Math.random()*100 )
		*/
        int randNum = (int)(Math.random()*100);
        //	System.out.println(randNum);

        //从键盘输入数，如果大了提示，大了，如果小了，提示小了，如果对了，就不再猜了，
        java.util.Scanner input = new java.util.Scanner(System.in);
        int num;//挪到do{}上面，提升作用域
        int count = 0;//统计次数
        do{
            System.out.print("猜数（范围[0,100)：");
            num = input.nextInt();

            count++;//输入一次，就代表猜一次

            if(num > randNum){
                System.out.println("大了");
            }else if(num<randNum){
                System.out.println("小了");
            }
        }while(num!=randNum);//条件成立，重复执行循环体语句

        System.out.println("一共猜了：" + count + "次");
    }
}
