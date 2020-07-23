/**
 * @author Liu Awen
 * @create 2018-05-08 12:55
 */
//8、使用 switch 把阿拉伯数字转为“零、壹、贰、叁、肆、伍、陆、柒、捌、玖”；其它的都输出 “other”。
class Test14_Exer8{
    public static void main(String[] args){
        //1、输入0-9的数字
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入0-9的数字：");
        int num = input.nextInt();
        //switch(num){
        //  case 1:
        //      xxx
        //      break;
        // }
        //2、转为中文大写数字
        switch(num){
            case 0:
                System.out.println("零");
                break;
            case 1:
                System.out.println("壹");
                break;
            case 2:
                System.out.println("贰");
                break;
            case 3:
                System.out.println("叁");
                break;
            case 4:
                System.out.println("肆");
                break;
            case 5:
                System.out.println("伍");
                break;
            case 6:
                System.out.println("陆");
                break;
            case 7:
                System.out.println("柒");
                break;
            case 8:
                System.out.println("捌");
                break;
            case 9:
                System.out.println("玖");
                break;
            default:
                System.out.println("other");
        }
    }
}
