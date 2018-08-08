package com.sola.alittledemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookController {

    @GetMapping("/book/{bookId}")
    public Object getBook(@PathVariable(name = "bookId") Long bookId) {
        // 获取book信息
        // 再次修改
        // feature02 和 feature01 修改同一份文件
        // 01: 增加用户身份验证
        // 02: 增加用户权限管理
        log.info("bookId is {}", bookId);
    }

}
