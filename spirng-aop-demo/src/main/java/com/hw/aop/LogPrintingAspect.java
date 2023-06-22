package com.hw.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogPrintingAspect {
    /**
     * 采用注解的方式指定切点
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.hw.customInterface.LogPrinting)")
    public Object beforeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method execution");
        String res = (String) joinPoint.proceed();
        Object result = res + ": info is changed";
        System.out.println("After method execution");
        return result;
    }
}
