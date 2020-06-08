package cn.liuawen.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-08
 */
public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();
        //增强对象
        final Advice advice = new Advice();

        //代理对象
        //三个参数
        //返回值 就是动态生成的代理对象
        TargetInterface proxy=(TargetInterface) Proxy.newProxyInstance(
                //目标对象类加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组 目标对象可能不止一个接口
                target.getClass().getInterfaces(),
                //
                new InvocationHandler() {
                    //invoke 调用代理对象的任何方法实质执行的都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();//前置增强
                        Object invoke = method.invoke(target,args);//执行目标方法                        //执行目标方法
                        advice.afterReturning();//后置增强
                        return invoke;
                    }
                }
        );

        //调用代理对象的方法
        proxy.save();
    }
}
