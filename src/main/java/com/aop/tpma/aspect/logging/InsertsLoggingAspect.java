package com.aop.tpma.aspect.logging;

import com.aop.tpma.domain.Actor;
import com.aop.tpma.domain.Genre;
import com.aop.tpma.domain.Play;
import com.aop.tpma.domain.Room;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class InsertsLoggingAspect {

    @AfterReturning(value = "execution(* com.aop.tpma.service.ActorService.saveActor(..)) " +
            "|| execution(* com.aop.tpma.service.GenreService.saveGenre(..))" +
            "|| execution(* com.aop.tpma.service.PlayService.savePlay(..))" +
            "|| execution(* com.aop.tpma.service.RoomService.saveRoom(..))"
            , returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        if (result != null) {
            if (result instanceof Actor) {
                log.info("A new actor was inserted({}): {} {}", joinPoint.getSignature().getName(), ((Actor) result).getFirstName(), ((Actor) result).getLastName());
            } else if (result instanceof Genre) {
                log.info("A new genre was inserted({}): {}", joinPoint.getSignature().getName(), ((Genre) result).getName());
            } else if (result instanceof Play) {
                log.info("A new play was inserted({}): {}", joinPoint.getSignature().getName(), ((Play) result).getTitle());
            } else if (result instanceof Room) {
                log.info("A new room was inserted({}): {}. Number of available seats: {}", joinPoint.getSignature().getName(), ((Room) result).getName(), ((Room) result).getNoOfSeats());
            }
        }
    }

    @AfterThrowing(value = "execution(* com.aop.tpma.service.ActorService.saveActor(..)) " +
            "|| execution(* com.aop.tpma.service.GenreService.saveGenre(..))" +
            "|| execution(* com.aop.tpma.service.PlayService.savePlay(..))" +
            "|| execution(* com.aop.tpma.service.RoomService.saveRoom(..))",
            throwing = "error")
    public void afterThrowingErrorHandling(JoinPoint joinPoint, Throwable error) {
            log.error("An insert was not performed: {}. The following error occurred: {}", joinPoint.getSignature(), error.getMessage());
    }
}
