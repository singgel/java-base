package com.hks.eightsortingalgorithms.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodTimeAspect.class);

    /**
     * 定义一个切入点.
     * 解释下：
     *
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 定义在web包或者子包
     * ~ 第三个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @Pointcut("execution(* com.hks.eightsortingalgorithms.method..*.*(..))")
    public void logPointcut(){}

    @Around("logPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.error("+++++around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.error("+++++around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }

    }

}
