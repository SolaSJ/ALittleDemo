package com.sola.alittledemo.controller;

import com.sola.alittledemo.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookController {

    @Autowired
    private Book book;

    @GetMapping("/book/{bookId}")
    public Object getBook(@PathVariable(name = "bookId") Long bookId) {
//        log.info("feature01 ---1");
//        log.info("feature, --2");
//        log.info("feature02, --1");
//        log.info("feature, --2");
//        log.info("bookId is {}", bookId);
        return null;
    }

}
