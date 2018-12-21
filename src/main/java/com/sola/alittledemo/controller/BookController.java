package com.sola.alittledemo.controller;

import com.alibaba.fastjson.JSON;
import com.sola.alittledemo.controller.vo.BookUtils;
import com.sola.alittledemo.service.bo.BookBO;
import com.sola.alittledemo.mapper.entity.BookDO;
import com.sola.alittledemo.controller.vo.BookVO;
import com.sola.alittledemo.service.IBookService;
import com.sola.alittledemo.common.validator.group.UpdateGroup;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/08
 */
@Slf4j
@RestController
public class BookController {

    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{bookId}")
    public Object getBook(@PathVariable(name = "bookId") Long bookId) {
        BookBO bookBo = bookService.getBook(bookId);
        BookVO bookVo = new BookVO();
        BookUtils.copy(bookBo, bookVo);
        return bookVo;
    }

    @GetMapping("/books")
    public Object listBooks(T t) {
        //
        // BookBO bookBo = JSON.parseObject(where, BookBO.class);
        // List<BookBO> bookBOS = bookService.listBooks(bookBo);
        // List<BookVO> bookVOS = new ArrayList<>();
        // BookUtils.copy(bookBOS, bookVOS);
        // return bookVOS;
        return null;
    }

    @PostMapping("/books")
    public Object insertBook(@RequestBody @Validated BookBO bookReq) {
        BookDO bookDO = new BookDO();
        BeanUtils.copyProperties(bookReq, bookDO);
        return bookService.insertBook(bookDO);
    }

    @PostMapping("/books/multi")
    public Object insertMultiBooks(@RequestBody @Valid List<BookBO> bookList) {
        return null;
    }

    @PostMapping("/books/upload")
    public Object uploadBook(@RequestParam("file") MultipartFile file) {
        return bookService.uploadBook(file);
    }

    @PutMapping("/books")
    public Object updateBook(@RequestBody @Validated({UpdateGroup.class}) BookBO bookReq) {
        return null;
    }

    @DeleteMapping("/books/{bookId}")
    public Object deleteBook(@PathVariable("bookId") Long bookId) {
        return bookService.deleteBook(bookId);
    }

    @DeleteMapping("/books")
    public Object deleteBooks(@RequestParam String bookIds) {
        List<Long> list = JSON.parseArray(bookIds, Long.class);
        return bookService.deleteBooks(list);
    }

}
