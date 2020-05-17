package test12;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
类的第三个组成部分：
	构造器，也称为构造方法，因为（1）它长的像方法（2）它编译后是一个实例初始化方法
长的像方法
编译后是一个实例初始化方法
1、构造器的作用
（1）构造对象，创建对象
和new一起使用，每次调用它就是在创建新的对象
（2）可以在创建对象的同时，给属性赋值

2、构造器的特点
（1）所有类都有构造器
（2）如果一个类没有显式声明构造器，那么编译器将会自动生成一个默认的无参构造
（3）如果一个类显式声明了构造器，那么编译器将不会自动生成默认的无参构造了
（4）构造器的名称必须与类名相同
（5）构造器没有返回值类型，也不写void
（6）构造器可以重载

重载：在同一个类中，方法名相同，形参列表不同的两个和多个方法，和返回值类型无关

3、构造器的语法结构
	【修饰符】 类名(){

	}
	【修饰符】 类名(形参列表){

	}

回忆：
	java.util.Scanner input = new java.util.Scanner(System.in);//调用的是有参构造
	int num = input.nextInt();//从键盘输入一个整数
	java.util.Random rand = new java.util.Random();//调用的是无参构造
	int num = random.nextInt(10);//产生一个[0,10)的整数
*/
class Test12_Constructor{
    public static void main(String[] args){
        //创建对象
        //类名 对象名 = new  类名();
        //Circle c = new Circle();

        Circle c = new Circle(1.2);//1.2给半径赋值，在创建对象的同时给属性赋值用的
        c.printInfo();

        c.setRadius(2.5);//创建对象之后，修改属性值用的
        c.printInfo();

        Circle c2 = new Circle();//先创建对象，不给半径赋值
        c2.setRadius(3.6);
        c2.printInfo();
    }
}
class Circle{
    private double radius;

    //double r：构造器的形参列表
    public Circle(double r){//有参构造
        radius = r;//给半径赋值
    }

    public Circle(){//无参构造

    }

    public void printInfo(){
        System.out.println("半径：" + radius);
    }

    public void setRadius(double r){
        radius = r;
    }

}