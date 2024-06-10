package ru.test.lesson1.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@Order(2)
public class ExceptionHandlerAspect {

    @AfterThrowing(value = "within(ru.test.lesson1.service.*) ||" +
            "within(ru.test.lesson1.controller.*)", throwing = "exception")
    public void catchingExceptions(JoinPoint joinPoint, Exception exception){
        log.warn("Ошибка при вызове метода {} в классе {}", joinPoint.getSignature().getName(), joinPoint.getSignature().getDeclaringType().getName());
        log.warn("Ошибка {}", exception.getMessage());
    }

}
