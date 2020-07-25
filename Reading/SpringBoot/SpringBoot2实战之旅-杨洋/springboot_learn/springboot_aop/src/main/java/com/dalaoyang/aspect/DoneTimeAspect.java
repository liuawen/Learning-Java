package com.dalaoyang.aspect;

import com.dalaoyang.annotation.DoneTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.aspect
 * @email yangyang@dalaoyang.cn
 * @date 2018/9/9
 */
@Aspect
@Component
public class DoneTimeAspect {

    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
        System.out.println("方法开始时间是:"+new Date());
        Object o = joinPoint.proceed();
        System.out.println("方法结束时间是:"+new Date()) ;
        return o;
    }
}
