package homework;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
?	1、声明矩形类Rectangle

?	（1）包含属性：长和宽，要求属性私有化

?	（2）包含两个构造器：无参和有参

?	（3）给每一个属性提供get/set方法

?	（4）public double getArea()

?	（5）public double getPerimeter()

?	（6）提供getInfo()返回矩形对象的信息

?			例如：长：2，宽：3，面积：6，周长：10

?	2、测试类TestRectangle
案例：

?	编写Test07类，在main方法中，

?	（1）创建一个Rectangle[]数组，长度为5

?	（2）并创建5个Rectangle的矩形对象，放到数组中，矩形的长和宽随机生成[0,10.0)范围内的值

?	（3）遍历显示

?	（4）按照面积从小到大排序

?	（5）再次遍历显示
*/
class Day08_Test07{
    public static void main(String[] args){
        Rectangle[] arr  = new Rectangle[5];
        for(int i=0; i<arr.length; i++){
            arr[i] = new Rectangle();
            double d1 = Math.random()*10;
            double d2 = Math.random()*10;
            arr[i].setLength(d1>d2?d1:d2);
            arr[i].setWidth(d1<=d2?d1:d2);
        }

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i].getInfo());
        }
        System.out.println("------------------------");
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<arr.length-i; j++){
                if(arr[j].getArea() > arr[j+1].getArea()){
                    Rectangle temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i].getInfo());
        }
    }
}
class Rectangle{
    private double length;
    private double width;

    public Rectangle(){

    }
    public Rectangle(double chang, double kuan){
        length = chang;
        width = kuan;
    }

    public void setLength(double chang){
        length = chang;
    }
    public double getLength(){
        return length;
    }
    public void setWidth(double kuan){
        width = kuan;
    }
    public double getWidth(){
        return width;
    }

    public double getArea(){
        return length * width;
    }
    public double getPerimeter(){
        return 2 * (length + width);
    }
    public String getInfo(){
        return "长：" + length + "，宽：" + width + "，面积：" + getArea() + "，周长：" + getPerimeter();
    }
}