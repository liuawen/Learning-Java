package homework;

/**
 * @author Liu Awen
 * @create 2018-05-09 15:12
 */
//案例：从键盘输入生日，判断星座
    //月 日  判断下  if

class Day03_Test04{
    public static void main(String[] args){
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("月：");
        int month = input.nextInt();

        System.out.print("日：");
        int day = input.nextInt();//28 29 30 31  日期不是键盘选择 是弹出日历用户选择

        //(1)水瓶座
        if(month==1 && day>=20 || month==2 && day<=18){
            System.out.println("水瓶座");
        }else if(month==2 && day>=19 || month==3 && day<=20){
            System.out.println("双鱼座");
        }else if(month==3 && day>=21 || month==4 && day<=19){
            System.out.println("白羊座");
        }else if(month==4 && day>=20 || month==5 && day<=20){
            System.out.println("金牛座");
        }else if(month==5 && day>=21 || month==6 && day<=21){
            System.out.println("双子座");
        }else if(month==6 && day>=22 || month==7 && day<=22){
            System.out.println("巨蟹座");
        }else if(month==7 && day>=23 || month==8 && day<=22){
            System.out.println("狮子座");
        }else if(month==8 && day>=23 || month==9 && day<=22){
            System.out.println("处女座");
        }else if(month==9 && day>=23 || month==10 && day<=22){
            System.out.println("天平座");
        }else if(month==10 && day>=24 || month==11 && day<=22){
            System.out.println("天蝎座");
        }else if(month==11 && day>=23 || month==12 && day<=21){
            System.out.println("射手座");
        }else if(month==12 && day>=22 || month==1 && day<=19){
            System.out.println("摩羯座");
        }
    }
}