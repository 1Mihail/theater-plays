package com.aop.tpma.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SecurityLoggingAspect {
    @After(value = "execution(* com.aop.tpma.security.jwt.AuthEntryPointJwt.commence(..))")
    public void afterUnauthorizedLoggingHandler(JoinPoint joinPoint) {
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            if (signatureArg instanceof AuthenticationException) {
                log.error("Unauthorized error: {}", ((AuthenticationException) signatureArg).getMessage());
                break;
            }
        }
    }

}
