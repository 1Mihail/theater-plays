package com.aop.tpma.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TheaterServiceAspect {
    private static final Logger LOGGER = LogManager.getLogger(TheaterServiceAspect.class);

    @Before(value = "execution(* com.aop.tpma.service.TheaterService.getTheaters())")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOGGER.info("Before method:" + joinPoint.getSignature());
    }

    @After(value = "execution(* com.aop.tpma.service.TheaterService.getTheaters())")
    public void afterAdvice(JoinPoint joinPoint) {
        LOGGER.info("After method:" + joinPoint.getSignature());
    }

}