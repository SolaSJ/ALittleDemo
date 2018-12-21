package com.sola.alittledemo.service.impl;

import com.sola.alittledemo.common.annotation.Log;
import com.sola.alittledemo.service.bo.BookBO;
import com.sola.alittledemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Sola
 * @date 2018/10/08
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    @Async(value = "asyncExecutor")
    @Log("测试异步方法")
    public void testAsync(BookBO book, String name, int age) {

        String s = Optional.ofNullable(name).orElse(null);
        log.info("name is {}", s);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("hello world");
    }

    @Override
    @Log("测试无参数方法")
    public void test() {

    }


}
