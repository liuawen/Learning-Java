package cn.mldn.mldnboot.aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect { 								// 定义业务层拦截
	private Logger log = LoggerFactory.getLogger(ServiceAspect.class);
	@Around("execution(* cn.mldn..service..*.*(..))")
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable {
		this.log.info("【*** Service-Before ***】执行参数：" + Arrays.toString(point.getArgs()));
		Object obj = point.proceed(point.getArgs()); 		// 进行具体业务调用
		this.log.info("【*** Service-After ***】返回结果：" + obj);
		return obj;
	}
}
