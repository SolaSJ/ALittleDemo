package com.sola.alittledemo.common.aop;

import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.common.annotation.Log;
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

    @Pointcut("@annotation(log)")
    public void logPointCut(Log log) {
    }

    @Before(value = "logPointCut(log)", argNames = "joinPoint,log")
    public void doBefore(JoinPoint joinPoint, Log log) {
        String[] argsArr = Arrays.stream(joinPoint.getArgs()).map(JSON::toJSONString).toArray(String[]::new);

        this.log.info("{} 传入参数为: {}", log.value(), Arrays.toString(argsArr));
    }
    //
    // @After("logPointCut(logTime)")
    // public void doAfter(Log logTime) {
    //     log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), logTime.value());
    // }

    @Around(value = "logPointCut(log)", argNames = "jp,log")
    public void watchPerformance(ProceedingJoinPoint jp, Log log) {
        try {
            long startTime = Instant.now().toEpochMilli();

            jp.proceed();

            String[] argsArr = Arrays.stream(jp.getArgs()).map(JSON::toJSONString).toArray(String[]::new);
            this.log.info("{} 传入参数为: {}, 耗时: {}ms", log.value(), Arrays.toString(argsArr), Instant.now().toEpochMilli() - startTime);
        } catch (Throwable throwable) {
            this.log.error("{} 调用方法异常", log.value());
            throwable.printStackTrace();
        }
    }

}
