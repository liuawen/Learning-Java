package cn.liuawen.inherit;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-31
 */
public class AbstractExtendClassExample extends AbstractClassExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }

    public static void main(String[] args) {
//        AbstractClassExample ac1 = new AbstractClassExample();
        //Error:(14, 36) java: cn.liuawen.inherit.AbstractClassExample是抽象的; 无法实例化
        AbstractClassExample ac2 = new AbstractExtendClassExample();
        ac2.func1();//func

        ac2.func2();
    }
}
