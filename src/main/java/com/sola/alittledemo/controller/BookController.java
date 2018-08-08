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
        log.info("feature01 ---1");
        log.info("feature, --2");
        log.info("feature02, --1");
        log.info("feature, --2");
        log.info("bookId is {}", bookId);
    }

}
