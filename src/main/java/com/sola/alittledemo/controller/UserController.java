package com.sola.alittledemo.controller;

import com.sola.alittledemo.entity.Book;
import com.sola.alittledemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sola
 * @date 2018/10/08
 */

@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public Object getUser(@PathVariable Long userId) {
        log.info("查询用户, 用户id: {}", userId);
        // develop直接修改
        // 测试中文
        return "查询用户, 用户id: " + userId;
    }

    @GetMapping("/user/testAsync")
    public Object testAsync() {
        log.info("start testAsync");

        userService.testAsync(new Book(1L, "book1"), "sususu", 100);
        userService.testAsync(new Book(1L, "book1"), "", 100);
        userService.testAsync(new Book(1L, "book1"), null, 100);

        userService.test();

        log.info("end testAsync");

        return "success";
    }

}
