package cn.liuawen.inherit;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-31
 */
public class SuperExtendExample extends SuperExample {
    private int z;
    public SuperExtendExample(int x, int y,int z) {
        super(x, y);
        this.z = z;
    }
    public SuperExtendExample(){
        super();
        System.out.println("SuperExtendExample的无参构造");
    }

    @Override
    public void func() {
        super.func();
        System.out.println("SuperExtendExample.func()");
    }

    public static void main(String[] args) {
        SuperExample e = new SuperExtendExample(1,2,3);
        e.func();
        //SuperExample.func()
        //SuperExtendExample.func()

        SuperExample e2 = new SuperExtendExample();
        e.func();
        //SuperExample的无参构造
        //SuperExtendExample的无参构造
        //SuperExample.func()
        //SuperExtendExample.func()
    }
}
