/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
三、有参无返回值的方法
1、声明格式
【修饰符】 void 方法名(形参列表){
	方法体
}

形参列表的格式：
	(数据类型 形参名)
	(数据类型1 形参名1, 数据类型2 形参名2, ....)

2、调用格式
（1）本类同级别
	方法名(实参列表);
（2）其他类中
	对象名.方法名(实参列表);

3、两个名词：
形参列表：声明时()中
	(数据类型1 形参名1, 数据类型2 形参名2, ....)
	(int n,int m, char x)
实参列表：调用时()中
	(3,5,'%')
	(a,b,c)

5、实参与形参
实参是赋值给形参赋值
要求，实参的个数、类型、顺序与形参一一对应
*/
class Test10_HasParamNoReturnValue{
    public static void main(String[] args){
        //1、创建对象
        GraphicTools tools  = new GraphicTools();

        //2、调用print5Line10ColumnStarRectangle()
        tools.print5Line10ColumnStarRectangle();

        //3、调用printRectangle(int n,int m,char x)
        tools.printRectangle(3,5,'%');//(3,5,'%')称为实参列表

        int a = 5;
        int b = 9;
        char c = '#';
        //4、调用printRectangle(int n,int m,char x)
        tools.printRectangle(a,b,c);//(a,b,c)称为实参列表
    }
}
//GraphicTools图形工具类
//这个工具类中，有各种打印图形的方法
class GraphicTools{
    //修饰符省略
    //(1)声明一个可以打印5行10列的*的矩形
    //无参无返回值
    void print5Line10ColumnStarRectangle(){
        for(int i=1; i<=5; i++){
            for(int j=1; j<=10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //(2)声明一个可以打印n行m列的某字符的矩形
    //让调用这个方法的程序员，来决定n，m，x的值
    //形参列表(int n, int m, char x)
    void printRectangle(int n, int m, char x){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                System.out.print(x);

            }
            System.out.println();
        }
    }
}
