/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
可变参数：JDK1.5之后引入的
	形参列表中出现了“数据类型... 形参名”形式的形参，就是可变参数。
JDK1.5之后引入的
形参列表中出现了 数据类型... 形参名 形式的形参 就是可变参数
灵活点
包含可变参数的方法的调用原则：
（1）可变参数的形参部分，可以传入0~n个对应类型的实参，也可以传入对应类型的数组对象
（2）非可变参数的形参部分，原来该怎么传，现在还怎么传

可变参数的声明的原则：
（1）一个方法只能包含一个可变参数
（2）可变参数必须是形参列表的最后一个

参数：
（1）形参
（2）实参
（3）命令行参数
（4）可变参数
（5）...
*/
class Test05_VarParam{
    public static void main(String[] args){
        System.out.println(sum(1,2));

        int[] arr1 = new int[0];
        System.out.println("0个元素的累加和：" + sum(arr1));//可变参数部分，传入了对应类型的数组对象

        int[] arr2 = {1,2,3,4,5};
        System.out.println("5个元素的累加和：" + sum(arr2));//可变参数部分，传入了对应类型的数组对象

        System.out.println("0个元素的累加和：" + sum());//可变参数部分，传入了0个实参的int值
        System.out.println("5个元素的累加和：" + sum(1,2,3,4,5));//可变参数部分，传入了5个实参的int值
        System.out.println("3个元素的累加和：" + sum(5,3,1));//可变参数部分，传入了3个实参的int值
        System.out.println("-------------------------------");

        //System.out.println("0个元素的最大值：" + max());//错误的，因为max方法有一个非可变参数的形参，必须传值
        System.out.println("1个元素的最大值：" + max(5));//5赋值给了非可变参数的形参
        System.out.println("5个元素的最大值：" + max(5,1,5,6,8));//第1个5赋值给了非可变参数的形参，剩下的给了可变参数
    }

    //声明一个方法，功能：可以求两个整数的和
    public static int sum(int a, int b){
        return a + b;
    }
    //声明一个方法，功能：可以求0~n个整数的累加和
	/*
	//该方法不能与下面的(int... nums)同时存在
	public static int sum(int[] nums){
		int sum = 0;
		for(int i=0; i<nums.length; i++){
			sum += nums[i];
		}
		return sum;
	}*/


    public static int sum(int... nums){
        //nums当成数组用
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }

    //声明一个方法，功能：可以求1~n个整数的最大值
    //int num1就是非可变参数部分
    //int... nums是可变参数
    public static int max(int num1, int... nums){
        int max = num1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

}