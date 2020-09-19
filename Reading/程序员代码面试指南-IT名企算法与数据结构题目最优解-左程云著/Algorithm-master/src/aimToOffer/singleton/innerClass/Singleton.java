package singleton.innerClass;

/**
 * Created by Dell on 2017-06-08.
 */
public class Singleton {
    private static class inner{
//        private inner(){}
        private static Singleton instance=new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return inner.instance;
    }
}
