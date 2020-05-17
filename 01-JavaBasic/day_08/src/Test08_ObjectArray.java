/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
数组是用来存一组数，这组数可以是基本数据类型，也可以是引用数据类型
例如：
	int[] arr; 存了一组整数
	char[] arr;存了一组单字符

	String[] arr; 存了一组字符串对象
	Student[] arr; 存了一组学生对象
	Circle[] arr; 存了一组圆对象
    数组 对象数组
    int[] arr;
    char[] arr;
    可以是基本数据类型 可以是引用数据类型
 当我们数组中存储了一组对象时，那么我们称为对象数组。
 存储了一组对象时 我我们称为对象数组呢
*/
class Test08_ObjectArray{
    public static void main(String[] args){
        //要用一个数组，存储5个圆对象，半径分别为1-5
        //(1)声明一个数组
        //数组的元素的类型是Circle
        Circle[] arr = new Circle[5];//这个new是创建数组对象

        //(2)为数组的元素赋值
        for(int i=0; i<arr.length; i++){
            //元素：数组名[下标]
            //arr[i].radius = i+1;//java.lang.NullPointerException
            //空指针异常 为什么呢
            //null.radius
            arr[i] = new Circle();//创建圆对象
            arr[i].radius = i+1;
        }

        //(3)遍历数组，打印每一个圆的信息
        for(int i=0; i<arr.length; i++){
            //现在的数组的元素arr[i]就是一个圆对象，既然是圆对象，就可以调用圆的属性和方法
            arr[i].printInfo();
            //System.out.println(arr[i]);
        }
    }
}
class Circle{
    double radius;

    double getArea(){
        return 3.14 * radius * radius;
    }

    void printInfo(){
        System.out.println("半径：" + radius + "，面积：" + getArea());
    }
}