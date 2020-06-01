package cn.liuawen.inherit;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-31
 */
public class InterfaceImplementExample implements InterfaceExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }

    public static void main(String[] args) {
        // InterfaceExample ie1 = new InterfaceExample(); // 'InterfaceExample' is abstract; cannot be instantiated
        InterfaceExample ie2 = new InterfaceImplementExample();
        ie2.func1();//func1
        System.out.println(InterfaceExample.x);//123
        //接口的成员（字段 + 方法）默认都是 public 的，并且不允许定义为 private 或者 protected。
        //
        //接口的字段默认都是 static 和 final 的。
        ie2.func2();//func2
    }
}