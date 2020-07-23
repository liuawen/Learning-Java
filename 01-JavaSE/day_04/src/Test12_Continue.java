/**
 * @author Liu Awen
 * @create 2018-05-08 16:02
 */
/*
continue：继续（了解）
只能用于循环结构

作用：提前结束本次循环，继续下一次循环
提前结束本次循环 本次循环之后的就不执行了
但下次循环继续执行
*/
class Test12_Continue{
    public static void main(String[] args){
        //2、打印1-100的偶数
        for(int i=1; i<=100; i++){
			/*
			遇到奇数，提前结束当次循环，跳过了continue后面的循环体语句，直接去执行i++，为下一次循环做准备
			*/
            if(i%2!=0){
                continue;
            }
            System.out.println(i);

//            //or
//            if (i%2==0){
//                System.out.println(i);
//            }
        }
    }
}
