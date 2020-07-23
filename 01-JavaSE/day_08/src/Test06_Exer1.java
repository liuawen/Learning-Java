/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
1、声明一个图形工具类，包含如下方法：
（1）double getTriangleArea(double base,double height)
（2）double getTriangleArea(double a,double b, double c)

double getTriangleArea(double base,double height)：方法签名或方法体

方法 = 方法签名/方法头 + 方法体

方法签名：【修饰符】 返回值类型 方法名(【形参列表】)
方法体：{}
*/
class Test06_Exer1{
    public static void main(String[] args){
        GraphicTools tools  = new GraphicTools();
        System.out.println("底为3，高为4的三角形面积是：" +tools.getTriangleArea(3,4));//低和高
        System.out.println("三边为3,4,5的三角形面积是："+ tools.getTriangleArea(3,4,5));

        System.out.println("三边为1,1,1的三角形面积是："+ tools.getTriangleArea(1,1,1));
    }
}
class GraphicTools{
    double getTriangleArea(double base,double height){
        return base * height / 2;
    }

    double getTriangleArea(double a,double b, double c){
        //任意两边之和大于第三边
        if(a+b>c && a+c>b && b+c>a){
            double p = (a+b+c)/2;
            double area = Math.sqrt(p * (p-a) * (p-b) * (p-c));//海伦公式
            return area;
        }else{
            return 0.0;//非三角形
        }
    }
}
