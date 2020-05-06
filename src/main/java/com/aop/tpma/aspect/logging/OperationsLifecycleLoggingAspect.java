package com.aop.tpma.aspect.logging;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class OperationsLifecycleLoggingAspect {
    @Before(value = "execution(* com.aop.tpma.service..*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Started new operation: {}", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* com.aop.tpma.service..*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("Finished operation: {}", joinPoint.getSignature().getName());
    }
}
