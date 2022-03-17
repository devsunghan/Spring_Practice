package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer() {}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed(); // joinPoint.proceed가 불러지면 실질적으로 실행이 됨
        // return이 있으면 result로 들어감, 위 코드를 기준으로 위, 아래가 실행 전 후가

        stopWatch.stop();
        System.out.println("total time : "+stopWatch.getTotalTimeSeconds());
    }

}
