package ru.ltrnt.littletwi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Around("execution(* ru.ltrnt.littletwi.service.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String nameOfMethod = methodSignature.getName();

        System.out.println("LOG: " + nameOfMethod + " starts");
        Object targetMethodResult = joinPoint.proceed();
        System.out.println("LOG: " + nameOfMethod + " ends");

        return targetMethodResult;
    }
}
