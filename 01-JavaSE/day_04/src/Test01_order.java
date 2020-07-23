/**
 * @author Liu Awen
 * @create 2018-05-08 20:59
 */
public class Test01_order {
    public static void main(String[] args) {

//        输出常量
        System.out.print(1);
        System.out.print('菜');
        System.out.print(2.0);
        System.out.print(true);
        System.out.print("菜鸡文");
        System.out.println(false);
        //1菜2.0true菜鸡文false
//        输出变量
        int a = 1;
        boolean b = true;
        char c = '牛';
        double d = 3.14;

        String school = "菜鸟文大学";
        System.out.print(a);
        System.out.print(c);
        System.out.print(d);
        System.out.print(b);
        System.out.print(school);
        System.out.println();
        //1牛3.14true菜鸟文大学

//        输出拼接结果
        System.out.print("a = " + a);
        System.out.print("c = " + c);
        System.out.print("d = " + d);
        System.out.print("b = " + b);
        System.out.print("school = " + school);
        //a = 1c = 牛d = 3.14b = trueschool = 菜鸟文大学
    }
}
