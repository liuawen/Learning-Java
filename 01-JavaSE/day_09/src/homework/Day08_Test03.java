package homework;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
?	在Test03类中，声明如下方法，并体会方法的参数传递机制：

1、public static  void  doubleNumber(int num)：
	尝试将num变为原来的2倍大，看是否可以将给num赋值的实参变量值也扩大2倍，
	为什么，如果不能，那怎么解决呢？
2、public static void toUpperCase(char letter)：
	尝试将letter的小写字母转为大写字母，看是否可以将给letter赋值的实参变量值也转为大写，
	为什么，如果不能，那怎么解决呢？
3、public static void expandCircle(Circle  c，double times)：
	尝试将Circle的c对象的半径扩大为原来的times倍，
	看是否可以将给c赋值的实参对象的半径也扩大times倍，为什么，如果不能，那怎么解决呢？
4、public static void sort(int[] arr)：尝试对arr数组实现从小到大排序，看是否可以将给arr赋值的实参数组也排序，为什么，如果不能，那怎么解决呢？
5、public static void concatAtguigu(String str)：尝试在str后面拼接“atguigu"字符串，看是否可以将给str赋值的实参字符串变量也修改了，为什么，如果不能，那怎么解决？
6、public static void main(String[] args)：以上方法在main中调用测试
*/
class Day08_Test03{
    public static void main(String[] args){
        int x = 1;
        //doubleNumber(x);
        x = doubleNumber(x);//返回两倍的值呢
        System.out.println("x = " + x);

        char c = 'a';
        //toUpperCase(c);
        c = toUpperCase(c);//又是赋值返回解决的
        System.out.println(c);

        Circle c1 = new Circle();
        c1.radius = 1.0;

        expandCircle(c1, 5);
        System.out.println("半径：" + c1.radius);

        String str = "hello";
        //concatAtguigu(str);
        str = concatAtguigu(str);
        System.out.println(str);
    }
    /*偷梁换柱
    public static  void  doubleNumber(int x){
        x *= 2;
        System.out.println("x = " + x);
        System.exit(0);
    }*/
    public static int doubleNumber(int num){
        return num*2;
    }

    //public static void toUpperCase(char letter){
    //	letter = (char)(letter - 32);
    //}
    public static char toUpperCase(char letter){
        return (char)(letter - 32);
    }

    public static void expandCircle(Circle  c,double times){
        c.radius *= times;
    }

    //尝试在str后面拼接“atguigu"字符串，看是否可以将给str赋值的实参字符串变量也修改了，
    //为什么，如果不能，那怎么解决？
    //不能，因为String类型比较特殊，它的对象是不可变对象，一旦修改（包括拼接）就会产生新对象
    //public static void concatAtguigu(String str){
    //	str += "atguigu";//str修改后会指向新对象，就不是原来的实参的那个字符串对象了
    //}
    public static String concatAtguigu(String str){
        return str += "atguigu";
    }

}
class Circle{
    double radius;
}