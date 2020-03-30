package com.aop.tpma.aspect;

import com.aop.tpma.domain.Actor;
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
public class ActorServiceAspect {
    private static final Logger LOGGER = LogManager.getLogger(ActorServiceAspect.class);

    @Before(value = "execution(* com.aop.tpma.service.ActorService.getActors())")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOGGER.info("Started new operation: {}", joinPoint.getSignature().getName());
    }

    @After(value = "execution(* com.aop.tpma.service.ActorService.getActors())")
    public void afterAdvice(JoinPoint joinPoint) {
        LOGGER.info("Started new operation: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.aop.tpma.service.ActorService.saveActor(..))", returning = "insertedActor")
    public void afterReturningAdvice(JoinPoint joinPoint, Actor insertedActor) {
        if (insertedActor != null) {
            LOGGER.info("A new actor was inserted({}): {} {}", joinPoint.getSignature().getName(), insertedActor.getFirstName(), insertedActor.getLastName());
        }
    }

    @Around(value = "execution(* com.aop.tpma.service.ActorService.saveActor(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        LOGGER.info("Execution time of {}.{} :: {} ms", methodSignature.getDeclaringType().getSimpleName(), methodSignature.getName(), stopWatch.getTotalTimeMillis());

        return result;
    }
}
