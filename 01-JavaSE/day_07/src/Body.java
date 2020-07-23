/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-17
 */
/*
类的提取：
	名词提取法，转换为现实世界中的事物的类别==》计算机程序中的类

类的设计：
	类的成员的设计
	5大成员（5大组成部分）：
	1、属性：数据特征
	2、方法：行为特征，功能特征
	3、构造器：创建对象时用
	4、代码块：在类初始化和对象初始化时用的
	5、内部类：在某个大的事物中，包含了一个独立的小的事物类别，而且一般这个小的事物只为大的事物服务时


类{
	成员列表
}
*/
class Body{
    //属性
    double weight;
    char gender;

    //方法
    void eat(){
        System.out.println("吃饭");
    }
    void sleep(){
        System.out.println("睡觉");
    }

    //构造器
    Body(){

    }
    Body(double weight, char gender){
        this.weight = weight;
        this.gender = gender;
    }

    //代码块
    {
        System.out.println("非静态代码块");
    }
    static{
        System.out.println("静态代码块");
    }

    //内部类
    class Heart{
        public void beat(){
            System.out.println("砰砰跳");
        }
    }

}
