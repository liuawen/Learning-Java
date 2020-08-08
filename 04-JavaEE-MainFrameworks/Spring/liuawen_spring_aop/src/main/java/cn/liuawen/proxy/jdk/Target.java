package cn.liuawen.proxy.jdk;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-08
 */
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
    }
}
