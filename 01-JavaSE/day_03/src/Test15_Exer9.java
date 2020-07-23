/**
 * @author Liu Awen
 * @create 2018-05-08 12:55
 */
/*
9、根据用于指定月份，打印该月份所属的季节。
3,4,5 春季 6,7,8 夏季  9,10,11 秋季 12, 1, 2 冬季
*/
class Test15_Exer9{
    public static void main(String[] args){
        //1、输入月份
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入月份：");
        int month = input.nextInt();
        System.out.println(13|14);//按位或运算符 15
        switch(month){
//            case 13|14:
//                System.out.println("15");
//                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入有误！");
        }
    }
}