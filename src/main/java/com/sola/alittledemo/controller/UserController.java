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
        // release01 修复develop上的bug
        // hotfix 修复bug
        // release分支修复, 测试
        // feature01分支
        // develop fastforward提交
        // develop fastforward 提交测试1
        // develop -no--ff 提交测试
        // dev02 --- 修改
        // dev02 --- 修改1
        // dev01
        // 发布分支1.0
        // 发布分支1.1
        // release-test
        return "查询用户, 用户id: " + userId;
    }

}
