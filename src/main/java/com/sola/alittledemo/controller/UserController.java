package com.sola.alittledemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/user/{userId}")
    public Object getUser(@PathVariable Long userId) {
        log.info("查询用户, 用户id: {}", userId);
        // 测试中文
        return "查询用户, 用户id: " + userId;
    }

}
