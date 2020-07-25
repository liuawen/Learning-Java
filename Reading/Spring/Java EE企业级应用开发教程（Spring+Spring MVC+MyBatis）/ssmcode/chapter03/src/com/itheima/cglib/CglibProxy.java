package com.itheima.cglib;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import com.itheima.aspect.MyAspect;
// 代理类
public class CglibProxy implements MethodInterceptor{
    // 代理方法
	public  Object createProxy(Object target) {
		// 创建一个动态类对象
		Enhancer enhancer = new Enhancer();
		// 确定需要增强的类，设置其父类
		enhancer.setSuperclass(target.getClass());
		// 添加回调函数
		enhancer.setCallback(this);
		// 返回创建的代理类
		return enhancer.create();
	}
	/**
	 * proxy CGlib根据指定父类生成的代理对象
	 * method 拦截的方法
	 * args 拦截方法的参数数组
	 * methodProxy 方法的代理对象，用于执行父类的方法 
	 */
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, 
            					 MethodProxy methodProxy) throws Throwable {
         // 创建切面类对象
		MyAspect myAspect = new MyAspect();
		// 前增强
		myAspect.check_Permissions();
		// 目标方法执行
		Object obj = methodProxy.invokeSuper(proxy, args);
		// 后增强
		myAspect.log();	
		return obj;
	}
}
