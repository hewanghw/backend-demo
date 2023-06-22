package com.hw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义一个切面类
 */
@Component
@Aspect
public class LoggingAspect {
    /**
     * 定义通知
     * beforeMethod方法为通知内容，也就是如何增强目标方法
     * Before注解表示前置通知，也就是在目标方法执行前执行
     * 切点表达式execution(* com.hw.controller.*.*(..))指定了要拦截所有Controller类的所有方法。
     */
    @Before("execution(* com.hw.controller.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before executing method: " + methodName);
    }

    /**
     * 定义切点
     */
    @Pointcut("execution(* com.hw.controller.*.*(..))")
    private void myPoint(){}

    /**
     * After注解表示后置通知
     */
    @After("myPoint()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After executing method: " + methodName);
    }

}
