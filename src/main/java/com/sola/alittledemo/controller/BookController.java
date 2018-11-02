package com.sola.alittledemo.controller;

import com.sola.alittledemo.bean.po.BookPo;
import com.sola.alittledemo.bean.param.BookParam;
import com.sola.alittledemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

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

    @PostMapping("/books")
    public Object insertBook(@RequestBody @Validated BookParam bookParam) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookParam, bookPo);
        return bookService.insertBook(bookPo);
    }

    @GetMapping("/books/{bookId}")
    public Object getBook(@PathVariable(name = "bookId") @Min(value = 1, message = "bookId最小为1") Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/books/upload")
    public Object uploadBook(@RequestParam("file") MultipartFile[] file) {
        return bookService.uploadBook(file);
    }

    @PostMapping("/books/multi")
    public Object insertMultiBooks(@RequestBody @Valid List<BookParam> bookList) {
        return null;
    }


    @PostMapping("/books/test")
    public Object uploadBook(@RequestBody Integer[] ids) {
        return null;
    }

}
