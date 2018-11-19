package com.sola.alittledemo.aop;

import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.annotation.LogTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @Before(value = "logPointCut(logTime)", argNames = "joinPoint,logTime")
    public void doBefore(JoinPoint joinPoint, LogTime logTime) {
        String[] argsArr = Arrays.stream(joinPoint.getArgs()).map(JSON::toJSONString).toArray(String[]::new);

        log.info("{} 传入参数为: {}", logTime.value(), Arrays.toString(argsArr));
    }
    //
    // @After("logPointCut(logTime)")
    // public void doAfter(LogTime logTime) {
    //     log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), logTime.value());
    // }

    @Around(value = "logPointCut(logTime)", argNames = "jp,logTime")
    public void watchPerformance(ProceedingJoinPoint jp, LogTime logTime) {
        try {
            long startTime = Instant.now().toEpochMilli();

            jp.proceed();

            String[] argsArr = Arrays.stream(jp.getArgs()).map(JSON::toJSONString).toArray(String[]::new);
            log.info("{} 传入参数为: {}, 耗时: {}ms", logTime.value(), Arrays.toString(argsArr), Instant.now().toEpochMilli() - startTime);
        } catch (Throwable throwable) {
            log.error("{} 调用方法异常", logTime.value());
            throwable.printStackTrace();
        }
    }

}
