/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
.java的源文件的结构：
类{

	方法{
		语句;//必须在方法中
	}
}
*/

class Test07_Error{
    public static void main(String[] args){
//        Circle c = new Circle();//这样使用有问题，后面再讲内部类的使用
    }
    //内部类，
    class Circle{
        double radius;

        //System.out.println("半径：" + radius);//错误的，不能把语句写到方法外面去
        void printInfo(){
            System.out.println("半径：" + radius);
        }

        //printInfo();//这也语句，调用方法的语句
        void test(){
            printInfo();
        }
    }
}
