/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
四、有参有返回值的方法
1、声明格式
【修饰符】 非void的返回值类型  方法名(形参列表){
	方法体
}

2、调用格式
（1）其他类中
	变量 = 对象名.方法名(实参列表);

	或

	System.out.println(对象名.方法名(实参列表));
（2）本类同级别调用
		变量 = 方法名(实参列表);

		或
		System.out.println(方法名(实参列表));
*/
class Test12_HasParamHasReturnValue{
    public static void main(String[] args){
        //1、创建MyMathTools对象
        MyMathTools tools = new MyMathTools();

        //2、调用max()
        int m = tools.max(4,6);
        System.out.println("4,6最大值是：" + m);

        System.out.println("5,2最大值是：" +tools.max(5,2) );

        //3、调用threeNumberMax
        System.out.println("3,2,7的最大值是：" + tools.threeNumberMax(3,2,7));
    }
}

//声明一个数学计算工具类
class MyMathTools{
    //1、求任意两个整数的最大值
    int max(int a, int b){
        return a>b ? a : b;
    }

    //2、求任意三个整数的最大值
    int threeNumberMax(int x, int y ,int z){
        //本类同级别调用
		/*
		int m = max(x,y);
		m = max(m,z);
		return m;
		*/
        return max(max(x,y),z);
    }
}