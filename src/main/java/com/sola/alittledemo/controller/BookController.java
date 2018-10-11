package com.sola.alittledemo.controller;

import com.sola.alittledemo.entity.Book;
import com.sola.alittledemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * @author Sola
 * @date 2018/10/08
 */

@Validated
@RestController
public class BookController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public Object insertBook(@RequestBody @Validated Book book) {
        return bookService.insertBook(book);
    }


    @GetMapping("/book/{bookId}")
    public Object getBook(@PathVariable(name = "bookId") @Min(value = 1, message = "bookId最小为1") Long bookId) {
        return bookService.getBook(bookId);
    }


}
