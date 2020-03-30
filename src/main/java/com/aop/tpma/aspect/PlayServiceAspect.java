package com.aop.tpma.aspect;

import com.aop.tpma.domain.Play;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PlayServiceAspect {
    private static final Logger LOGGER = LogManager.getLogger(PlayServiceAspect.class);

    @Before(value = "execution(* com.aop.tpma.service.PlayService.getPlays())")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOGGER.info("Started new operation: {}", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* com.aop.tpma.service.PlayService.getPlays())")
    public void afterAdvice(JoinPoint joinPoint) {
        LOGGER.info("Started new operation: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.aop.tpma.service.PlayService.savePlay(..))", returning = "insertedPlay")
    public void afterReturningAdvice(JoinPoint joinPoint, Play insertedPlay) {
        if (insertedPlay != null) {
            LOGGER.info("A new play was inserted({}): {}", joinPoint.getSignature().getName(), insertedPlay.getTitle());
        }
    }

    @Around(value = "execution(* com.aop.tpma.service.PlayService.savePlay(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        LOGGER.info("Execution time of {}.{} :: {} ms", className, methodName, stopWatch.getTotalTimeMillis());

        return result;
    }

}