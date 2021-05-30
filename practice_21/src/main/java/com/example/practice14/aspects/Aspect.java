package com.example.practice14.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect{
    @Around("within(com.example.practice14.services.*)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeStart = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long timeWork = System.currentTimeMillis() - timeStart;
        log.info(joinPoint.getSignature() + " worked for " + timeWork + "ms");
        return proceed;
    }
}

