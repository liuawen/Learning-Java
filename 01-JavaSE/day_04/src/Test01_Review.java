/**
 * @author Liu Awen
 * @create 2018-05-08 14:27
 */
class Test01_Review{
    public static void main(String[] args){
        int score = 10;//省略输入

        if(score<0 || score>100)
            System.out.println("输入有误！");//简单的语句
        else
            //复合语句
            if(score==100){
                System.out.println("满分");
            }else if(score>=80){
                System.out.println("优秀");
            }else if(score>=60){
                System.out.println("及格");
            }else{
                System.out.println("不及格");
            }
    }
}