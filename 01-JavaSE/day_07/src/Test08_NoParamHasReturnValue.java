/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
无参有返回值的方法：
double d = Math.random() ;
int num = input.nextInt();
double d = input.nextDouble() ;

一、无参有返回值的方法
1、声明格式
【修饰符】 非void的返回值类型 方法名(){
	方法体
}

2、调用格式
（1）其他类中：
	变量 = 对象名.方法名();
	或
	System.out.println(对象名.方法名());

	这个变量用来接收返回值
（2）本类的同级方法中
	变量 = 方法名();
	或者
	System.out.println(方法名());
*/
class Test08_NoParamHasReturnValue{
    public static void main(String[] args){
        //1、创建对象
        Account a = new Account();
        a.id = "10101010101";
        a.balance = 10000;

        //调用a的printInfo()
        a.printInfo();

        //调用a的getMonthlyRate()
        //变量 = 对象名.方法名();//无参有返回值的方法的调用
        double d = a.getMonthlyRate();
        System.out.println("月利率：" + d);
    }
}
//Account账户
class Account{
    String id;//账号
    double balance;
    double rate = 0.035;//年利率，后面再讲静态的问题，这里没有用静态

    //1、打印当前账户的信息
    void printInfo(){
        System.out.println("账户：" + id +
                "，余额：" + balance +
                "，年利率：" + rate +
                "，月利率：" + getMonthlyRate());//本类同级方法中调用，可以省略“对象名.”
    }

    //2、返回月利率
    //月利率 = 年利率 / 12;
    double getMonthlyRate(){
        return rate / 12;
    }
}