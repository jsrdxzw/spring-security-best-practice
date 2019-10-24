package com.jsrdxzw.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/24
 * @Description:
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.jsrdxzw.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("time aspect start");
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        for (Object arg : joinPoint.getArgs()) {
            System.out.println(arg);
        }
        long end = System.currentTimeMillis();
        System.out.println("time aspect 耗时:" + (end - start));
        System.out.println(result);
        System.out.println("time aspect end");
        return result;
    }
}
