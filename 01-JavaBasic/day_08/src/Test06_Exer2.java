/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
2、声明一个数学工具类，包含如下方法：
（1）可以求0~n字符串的拼接结果
（2）可以求1~n整数的乘积

*/
//怎么写呢 类与对象   写功能吧
class Test06_Exer2{
    public static void main(String[] args){
        MyMath my = new MyMath();
        //连接起来
//        System.out.println("拼接结果：" + my.concat("尚硅谷", "是","一家","靠谱的","培训机构"));
        System.out.println("拼接结果：" + my.concat("菜鸡文", "是","真得菜","是一个傻逼呀"));
        System.out.println("5! = " + my.mutiply(1,2,3,4,5));
    }
}
class MyMath{
    //（1）可以求0~n字符串的拼接结果
    String concat(String... args){
        String str = "";//空字符串
        for(int i=0; i<args.length; i++){
            str += args[i];
        }
        return str;
    }

    //（2）可以求1~n整数的乘积
    long mutiply(int a, int... nums){
        //乘积可能比较大  来搞long
        long result = a;
        for(int i=0; i<nums.length; i++){
            result *= nums[i];
        }
        return result;
    }
}