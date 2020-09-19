package singleton.staticImpl;

/**
 * 如果该类中有其他方法，会导致过早创建实例，浪费内存
 * Created by Dell on 2017-06-08.
 */
public class Singleton
{
    private static Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
