package com.zhumj.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class LogAspect {


    @Pointcut("execution(* com.zhumj.component..*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void printParam(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        System.out.println("before: " + Arrays.toString(args));
    }

    @Around("pointcut()")
    public Object processParam(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("around: " + Arrays.toString(proceedingJoinPoint.getArgs()));

        Object proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        System.out.println("around结果：" + proceed);

        return proceed;

    }





}
