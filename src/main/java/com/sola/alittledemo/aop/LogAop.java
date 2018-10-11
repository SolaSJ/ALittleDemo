package com.sola.alittledemo.aop;

import com.sola.alittledemo.annotation.LogTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;

/**
 * @author Sola
 * @date 2018/10/09
 */
@Aspect
@Component
public class LogAop {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    // ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Pointcut("@annotation(logTime)")
    public void logPointCut(LogTime logTime) {
    }

    // @Before("logPointCut(logTime)")
    // public void doBefore(JoinPoint joinPoint, LogTime logTime) {
    //     // 记录请求到达时间
    //     beginTime.set(System.currentTimeMillis());
    //     log.info("cy666 note:{}", logTime.value());
    // }
    //
    // @After("logPointCut(logTime)")
    // public void doAfter(LogTime logTime) {
    //     log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), logTime.value());
    // }

    @Around("logPointCut(logTime)")
    public void watchPerformance(ProceedingJoinPoint jp, LogTime logTime) {
        try {
            long startTime = Instant.now().toEpochMilli();
            jp.proceed();

            Object[] args = jp.getArgs();

            log.info("[{}] 传入参数为: {}, 耗时: {}ms", logTime.value(), Arrays.toString(args), Instant.now().toEpochMilli() - startTime);
        } catch (Throwable throwable) {
            log.error("[{}] 调用方法异常", logTime.value());
            throwable.printStackTrace();
        }
    }

}
