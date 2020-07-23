package cn.liuawen.inherit;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-31
 */
public class SuperExample {
    protected int x;
    protected int y;

    public  SuperExample(){
        System.out.println("SuperExample的无参构造");
    }
    public SuperExample(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void func(){
        System.out.println("SuperExample.func()");
    }

}
