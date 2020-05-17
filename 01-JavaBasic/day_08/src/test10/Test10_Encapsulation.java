package test10;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
面向对象的基本特征：
（1）封装
（2）继承
（3）多态
封装  封装 为什么要封装呢 怕别人看到 封装 身份证 户口本
一、封装

1、封装的意义：
（1）隐藏实现细节
（2）安全

2、封装的类型：
（1）属性的封装、方法的封装等
（2）组件的封装
（3）系统的封装
访问的接口   支付宝  不给你看代码  给你一个基本的组件 你调用 返回信息给你

3、封装的实现，靠权限修饰符来控制可见的范围。
权限修饰符：
(1)可见范围
				本类	本包	其他包子类		任意位置
private：		 √		×			×				×
缺省/省略：		 √		√			×				×
protected：		 √		√			√				×
public			 √		√			√				√
default
(2)哪些可以加权限修饰符
类、属性、方法、构造器、内部类

(3)分别可以加什么权限修饰符
类：缺省或public
	如果类前面有public，那么必须与源文件名相同
	源文件名相同  属性
属性：四种都可以
方法：四种都可以

4、属性的封装
大多数情况下，属性都是private
如果属性私有化了，我们会提供get/set方法
get/set的标准写法：
	public void set属性名(数据类型 形参名){
		属性名 = 形参名;
	}
	public 属性的数据类型 get属性名(){
		return 属性名;
	}

5、方法的封装
大多数情况下，方法都是public

*/
public class Test10_Encapsulation{
    public static void main(String[] args){
        //1、创建对象
        Circle c1 = new Circle();

        //2、为属性赋值
        //c1.radius = 1.2;//错误的
        c1.setRadius(1.2);

        System.out.println("半径：" + c1.getRadius());
    }
}
class Circle{
    private double radius;//仅限与本类中访问

    //radius属性的set方法，用于在其他类中修改radius的值
    public void setRadius(double r){
        if(r>0){//使得赋值可控
            radius = r;
        }
    }
    //radius属性的get方法，用于在其他类中获取radius的值
    public double getRadius(){
        return radius;
    }

}