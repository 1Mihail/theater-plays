package com.aop.tpma.aspect.security;

import com.aop.tpma.exception.ForbiddenException;
import com.aop.tpma.security.jwt.JwtUtils;
import com.aop.tpma.util.Role;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class RoleSecurityHandlerAspect {
    @Autowired
    private JwtUtils jwtUtils;

    @Before(value = "execution(* com.aop.tpma.controller.GenreController.*(..)) " +
            "|| execution(* com.aop.tpma.controller.PlayController.*(..))" +
            "|| execution(* com.aop.tpma.controller.RoomController.*(..))")
    public void beforeAdvice() {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        String jwt = jwtUtils.parseJwt(request);
        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
            String role = jwtUtils.getRoleFromJwtToken(jwt);
            if (!role.equalsIgnoreCase(Role.ADMIN.toString()) && !role.equalsIgnoreCase(Role.MANAGER.toString())) {
                throw new ForbiddenException("Your role is " + role + " and you are not allowed to view this content!");
            }
        }

    }
}
